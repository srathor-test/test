# Caesar Cipher Batch
B)	Build a Spring Boot Batch application that take two input parameters, the first one is path to a text file, the second one is number of threads. The batch  should take the file input and split the file content by lines to each thread and run Caesar cipher for each line, the final output should be an encrypted text file.
### Compilation and Running
mvn clean install 

mvn spring-boot:run -Dspring-boot.run.arguments=--input.file=<valid input file>,--thread.pool.size=<thread pool size>

mvn spring-boot:run -Dspring-boot.run.arguments=--input.file="E:\\test\\batch\\src\\main\\resources\\in.txt",--thread.pool.size=10