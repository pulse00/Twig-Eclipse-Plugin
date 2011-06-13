the is based on the SmartyTokenizer

http://code.google.com/p/smartypdt/source/browse/trunk/org.eclipse.php.smarty.core/src/org/eclipse/php/smarty/internal/core/documentModel/parser/devTools/SmartyTokenizer.jflex

which in turn is based on the PHPTokenizer.jflex from PDT.

It can only be compiled with version 1.2.2 of jflex.
There's no official binary of this version available, i've received
one from the PDT mailinglist.

Until i figured out if it's ok to include the 1.2.2 binary into the
repository, i'll add it to .gitignore.


The main modifications of the PHPTokenizer are:


1. skeleton.sse

line ~294:

findTwigDelimiter method has been added


2. TwigTokenizer.jflex


line 97/98: delimiter fields have been added

line 930-933: states have been added

line 1320: macros have been added

line 1940: findTwigDelimiter method has been added to return the correct element

line 1950 - 2044: twig grammar additions


