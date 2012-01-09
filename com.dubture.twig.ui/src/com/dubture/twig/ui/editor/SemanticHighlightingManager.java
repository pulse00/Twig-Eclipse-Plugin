package com.dubture.twig.ui.editor;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.wst.sse.ui.internal.preferences.ui.ColorHelper;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.editor.highlighters.AbstractSemanticHighlighting;

@SuppressWarnings("restriction")
public class SemanticHighlightingManager
{
    
    private static SemanticHighlightingManager instance;

    private List<AbstractSemanticHighlighting> rules = new LinkedList<AbstractSemanticHighlighting>();

    private Map<String, AbstractSemanticHighlighting> highlightings = new LinkedHashMap<String, AbstractSemanticHighlighting>();

    public synchronized static SemanticHighlightingManager getInstance() {
        if (instance == null) {
            instance = new SemanticHighlightingManager();
        }
        return instance;
    }

    private SemanticHighlightingManager() {
        super();
        IConfigurationElement[] elements = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(
                        "org.eclipse.wst.sse.ui.semanticHighlighting");
        try {
            loadContributor(elements);
            // Sort the contributors according to their priority
            Collections.sort(rules);
            // Add contributors to the map
            for (AbstractSemanticHighlighting rule : rules) {
                highlightings.put(rule.getPreferenceKey(), rule);
            }
        } catch (Exception e) {
            Logger.logException(e);
        }
    }

    private SemanticHighlightingManager loadContributor(
            IConfigurationElement[] elements) throws Exception {
        for (IConfigurationElement element : elements) {
            String target = element.getAttribute("target");
            if ("com.dubture.twig.core.twigtemplate".equals(target)) {
                final Object o = element.createExecutableExtension("class");
                if (o instanceof AbstractSemanticHighlighting) {
                    AbstractSemanticHighlighting instance = (AbstractSemanticHighlighting) o;
                    rules.add(instance);
                }
            }
        }
        return this;
    }

    public Map<String, AbstractSemanticHighlighting> getSemanticHighlightings() {
        return highlightings;
    }

    /**
     * Initialize default preferences in the given preference store.
     * 
     * @param store
     *            The preference store
     */
    public SemanticHighlightingManager initDefaults(IPreferenceStore store) {
        Collection<AbstractSemanticHighlighting> semanticHighlightings = highlightings
                .values();
        for (AbstractSemanticHighlighting rule : semanticHighlightings) {
            rule.initDefaultPreferences();
            SemanticHighlightingStyle style = rule.getStyle();
            setDefaultAndFireEvent(store, rule.getColorPreferenceKey(),
                    style.getDefaultTextColor());
            // setDefaultAndFireEvent(store,
            // rule.getBackgroundColorPreferenceKey(), style
            // .);
            store.setDefault(rule.getBoldPreferenceKey(),
                    style.isBoldByDefault());
            store.setDefault(rule.getItalicPreferenceKey(),
                    style.isItalicByDefault());
            store.setDefault(rule.getStrikethroughPreferenceKey(),
                    style.isStrikethroughByDefault());
            store.setDefault(rule.getUnderlinePreferenceKey(),
                    style.isUnderlineByDefault());
            store.setDefault(rule.getEnabledPreferenceKey(),
                    style.isEnabledByDefault());
        }
        return this;
    }

    /**
     * Sets the default value and fires a property change event if necessary.
     * 
     * @param store
     *            the preference store
     * @param key
     *            the preference key
     * @param newValue
     *            the new value
     */
    private static void setDefaultAndFireEvent(IPreferenceStore store,
            String key, RGB newValue) {
        RGB oldValue = null;
        if (store.isDefault(key))
            oldValue = PreferenceConverter.getDefaultColor(store, key);

        PreferenceConverter.setDefault(store, key, newValue);
        store.setDefault(key, ColorHelper.toRGBString(newValue));

        if (oldValue != null && !oldValue.equals(newValue))
            store.firePropertyChangeEvent(key, oldValue, newValue);
    }    

}
