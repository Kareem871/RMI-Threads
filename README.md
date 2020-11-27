# RMI-Threads

#Create 5 thread that send and recieve random message between eachother
#Then count the number of letters between them.

cd Desktop\Question1\Question1
javac src/rmiinterface/RMIInterface.java src/clientserver/ClientServer.java src/rmiimplementaion/RMIImplementation1.java

cd src
start rmiregistry
java clientserver.ClientServer s1


cd ..\Question1\Question1\src

java clientserver.ClientServer s2

cd ..\Question1\Question1\src

java clientserver.ClientServer s3

cd ..\Question1\Question1\src

java clientserver.ClientServer s4

cd ..\Question1\Question1\src

java clientserver.ClientServer s5
