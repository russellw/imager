R:
cd \

del *.class
javac -d . --enable-preview -source 18 C:\imager\src\*.java
java %*

C:
cd \imager
