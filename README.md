# Order Records Sorter
Source code for coding challenge.

#### Design decisions:
The whole application is divided into the parent package, a service layer and a DAO layer. 
- The main driver is contained in the parent package. 
- The driver takes in the command line arguments for input and output filenames,
	and calls service method with these filenames to perform sorting.
- Service layer depends on DAO object to get the collection containing input records.
- Service layer also depends on DAO layer to write sorted values back to file.

#### Sorting:
This is lexicographical sorting while ignoring case, since this human entered data, pizza could be entered as Pizza as well,
both of which should have the same order, and tie to be resolved based on epoch time.

#### Frameworks used:
- Maven
- Spring boot
- JUnit, Mockito

#### Assumptions:
1. Whole input records file can be read into memory at once.
2. First line of the input file will always be the header.
3. In a production project, a logging service will be used, instead of console outputs, to record processing information.

#### Future changes:
1. If a DB is used instead of files, necessary changes can be made in the DAO layer, so that it read from DB instead of file.
2. If a file is sent over web interface, a controller will need to implemented which will then pass on the file to service layer.

#### Running the application:
- Source code is located in the zip file named FileSorter.zip
- An executable jar is bundled along with this readme and the source code. To run execute:
	`java -jar Aquent-0.0.1-SNAPSHOT <path-to-input-file> <path-to-output-file>`

- To run tests, execute:
	`mvn test`
