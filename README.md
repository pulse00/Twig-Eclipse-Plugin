#Twig Eclipse Plugin

The plugin is still in development. 

#Notice 

Since version 1.0.84 the plugin <span><b>REQUIRES</b></span> a nightly build of the PHP Development Tools. Please see the "Installation" section of the Symfony2 Eclipse Plugin for details on how to install a PDT nightly build: http://pulse00.github.com/Symfony-2-Eclipse-Plugin/.

If you're updating from an older version of the plugin, you need to uninstall your current PHP Development Tools (if it's not a nightly build) and install the PDT nightly build. 


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