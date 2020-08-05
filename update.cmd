del *.class
del index.html
javac CreatePage.java
java CreatePage codes index.html
copy *.js dist
copy *.css dist
copy index.html dist
copy leetcode.json dist
