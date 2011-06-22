package org.eclipse.twig.core.codeassist.strategies;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;
import org.eclipse.twig.core.codeassist.ITwigCompletionStrategyFactory;
import org.eclipse.twig.core.codeassist.context.VariableFieldContext;


/**
 * 
 * 
 * @see VariableFieldContext
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings("restriction")
public class VariableFieldStrategy extends AbstractTwigCompletionStrategy {

	
	private static final String ICOMPLETION_ID = "org.eclipse.twig.core.completion";	
	
	public VariableFieldStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {
						
		VariableFieldContext ctx = (VariableFieldContext) getContext();		
		System.err.println("complete variable " + ctx.getVariable());
		
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(ICOMPLETION_ID);
		
		System.err.println("so " + config.length);
		try {
			for (IConfigurationElement e : config) {
				System.out.println("Evaluating extension");
				final Object o = e.createExecutableExtension("class");
				if (o instanceof ITwigCompletionStrategyFactory) {
					ISafeRunnable runnable = new ISafeRunnable() {
						@Override
						public void handleException(Throwable exception) {
							System.out.println("Exception in client");
						}

						@Override
						public void run() throws Exception {
							((ITwigCompletionStrategyFactory) o).complete();
						}
					};
					SafeRunner.run(runnable);
				}
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}		
	}
}