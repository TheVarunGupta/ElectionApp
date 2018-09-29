<!DOCTYPE HTML>
<html>
<body>

<h1> Election Commission Application:</h1>
<hr>
<p>This application is focused on to improve the way people make votes with the help of their aadhaar numbers. People have only one aadhar number associated with them so we can make a better use of it and implement a system, where people can quickly and easily vote to parties in their respective states with the help of this application.</p>

<h3>Prerequisites & Software Required</h3>
<p>
<ul style="list-style-type:disc">
    <li>JAVA</li>
    <li>Android Studio</li>
    <li>Android phone with API 21 and Above</li>
</ul>
</p>

<h3>Database</h3>

<p>The database is stored in form of a large JSON document on Firebase and an integration is performed between the database and the android app. <br>
    Apart from this, the data of parties in the various states is stored in the form of a structured CSV delimited file.
</p>


<h3>Hadoop Commands Used</h3>
<ul style="list-style-type:disc">
    <li>Hadoop fs -put (filename)</li>
        <p>This command puts the file into HDFS. We use it to put our dataset into the cluster.</p>
    <li>Hadoop fs -get (folder/file name)</li>
        <p> This command get the file/folder from hdfs and puts it into your pc. We use this to retrieve the results for further use in JupyterNotebook.</p>
    <li>Hadoop fs -cat (filename)</li>
        <p> This command is used to read the output retrieved after executing map reduce functions.</p>
    <li> hs (mapper filename) (reducer filename) (input filename) (output filename)</li>
        <p> This command is an alias provided by cloudera that is used to execute the map reduce function.</p>
    <li>Hadoop fs -rm (filename)</li>
        <p> This command is used to delete any non-empty folder/ any file in the HDFS.</p>
    <li>Hadoop fs -rmr (foldername)</li>
        <p> This command is used to recursively delete files inside a folder.</p>
</ul>

<h3>Data Achieved:</h3>
<p>After using hadoop map reduce commands I achieve a data which looks like this:</p>
<p><i>
    "Arsenic" 	9499.0<br>
    "Fluoride" 	33299.0<br>
    "Iron" 	101708.0<br>
    "Nitrate" 	2551.0<br>
    "Salinity" 	32609.0<br>
    MAX: "Iron" 	101708.0<br>
    MIN: "Nitrate" 	2551.0</i>
</p>
<p>This data only represents the results achieved after running map reduce on 2009's data.<br>
Similary, I ran the code on the rest of the data and achieved the same for the rest of the years.<br>
Then, I import this data from the Virtual Machine to my windows and put it into a dataframe for the normalization and visualization part.</p>

<h3>Normalization and Visualization:</h3>
<p> This data is now imported into the dataframe. Now we can call the methods of scikit library to normalize and visualize the data henceforth.
    <br>You can find the code in the pynb file in the repository.</p>
</p>
<h3>Results:</h2>
    <a href="https://imgbb.com/"><img src="https://image.ibb.co/jqms29/Trend.png" alt="Trend" border="0"></a>
    <p>This image shows the normalized data, it shows for each element what the trend it folows. That is, how much it's occurence in our country has changed over the course of four years. For more details, you can refer to the report included in the repository. It shows more detailed analysis of the data with more images showing how the trend for individual element has changed. </p>
</body>
</html>