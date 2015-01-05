classesDir: 
	mkdir -p classes

build: src/RemoteDeviceDiscovery.java classesDir
	javac -d classes/ -cp ../jars/bluecove-2.1.0.jar src/*.java

deviceDiscovery: 
	java -cp classes/:../jars/bluecove-2.1.0.jar:../jars/bluecove-gpl-2.1.0.jar RemoteDeviceDiscovery

putClient: 
	java -cp classes/:../jars/bluecove-2.1.0.jar:../jars/bluecove-gpl-2.1.0.jar ObexPutClient

putServer:
	java -cp classes/:../jars/bluecove-2.1.0.jar:../jars/bluecove-gpl-2.1.0.jar OBEXPutServer	

serviceSearch:
	java -cp classes/:../jars/bluecove-2.1.0.jar:../jars/bluecove-gpl-2.1.0.jar ServicesSearch	

connectToServerExample:
	@read -p "Enter  URL:" url; \
	java -cp classes/:../jars/bluecove-2.1.0.jar:../jars/bluecove-gpl-2.1.0.jar ObexPutClient $$url


clean:
	rm -rf classes/*