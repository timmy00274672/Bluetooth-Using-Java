classesDir: 
	mkdir -p classes

build: src/RemoteDeviceDiscovery.java classesDir
	javac -d classes/ -cp ../jars/bluecove-2.1.0.jar src/RemoteDeviceDiscovery.java

run: build
	java -cp classes/:../jars/bluecove-2.1.0.jar:../jars/bluecove-gpl-2.1.0.jar RemoteDeviceDiscovery

clean:
	rm -rf classes/*