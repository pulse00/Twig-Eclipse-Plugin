# @author Yucca Nel

#!/bin/sh

#This installs maven2 & a default JDK 
sudo apt-get uninstall maven2 > /dev/null;
sudo apt-get install maven2 > /dev/null;

#Makes the /usr/lib/mvn in case...
sudo mkdir -p /usr/lib/mvn;

#Clean out /tmp...
sudo rm /tmp/apache-maven-3.0.3-bin.tar.gz;
sudo rm -rf /tmp/apache-maven-3.*
cd /tmp;

#Update this line to reflect newer versions of maven
wget http://mirrors.powertech.no/www.apache.org/dist//maven/binaries/apache-maven-3.0.3-bin.tar.gz > /dev/null;
tar -xvf ./*gz;

#Move it to where is a logical location
sudo mv /tmp/apache-maven-3.* /usr/lib/mvn/;

#Link the new Maven to the bin... (update for higher/newer version)...
sudo ln -s /usr/lib/mvn/apache-maven-3.0.3/bin/mvn /usr/bin/mvn;

exit 0;
