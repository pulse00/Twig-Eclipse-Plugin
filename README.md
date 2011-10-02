#Twig Eclipse Plugin

The plugin is still in development. 

#Notice 

Since version 1.0.85 the plugin <span><b>REQUIRES</b></span> a development version of the PHP Development Tools.

The development PDT version is available in the updatesite:

http://pulse00.github.com/updatesite/


If you're updating from an older version of the plugin (<= 1.0.84), you need to uninstall your current PHP Development Tools and install PDT from the above updatesite. 


## Current features

* Syntax highlighting
* Code assist for twig keywords
* Template support for language constructs (foreach / block / etc)
* Autoclose twig tags
* Code folding
* Outline
* "New Twig template" wizard and shortcut
* Extension point to let other plugins provide codeassist suggestions

The plugin requires [Eclipse >= 3.7.0 (Indigo)](http://www.eclipse.org/downloads/).

## Installation

* Help
* Install new Software...
* Click "add" to add a new software site
* Put the update-site in the location field: http://pulse00.github.com/updatesite/
* Select the "Twig Editor Feature" from the "Twig" node and click finish

Please use the github issue tracker to report bugs and feature requests.

## FAQ

### How can i use the twig editor for other file extensions than .twig?

1. Open Eclipse Preferences -> General -> Content Types
2. Under Text -> PHP Content Type -> Twig Template add the file association you need
3. Close any currently open editors
4. Reopen the file using "open with... -> Twig Editor" and you should get twig support.


## Contribute

Any contributions to the project are welcome, including:

* Code contributions
* Provide code-templates for standard twig control structures
* Report bugs
* Give feedback to the usage of the plugin