del *.class
del index.html
javac CreatePage.java
java CreatePage
copy *.js dist
copy *.css dist
copy index.html dist
copy leetcode.json dist
