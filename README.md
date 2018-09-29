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
    Apart from this, the data of parties in the various states is stored in the form of a structured CSV delimited file. You can see the screenshot here for reference of the data is stored:
</p>
<a href="https://ibb.co/ikqp3e"><img src="https://preview.ibb.co/fZeSpK/Database.png" alt="Database" border="0"></a>


<h3>Activities:</h3>
<ul style="list-style-type:disc">
    <li>SplashScreen</li>
        <p>This activity is used to display an image as a logo with the help of various animations</p>
    <li>LoginScreen</li>
        <p> This activity is used to get information from the user and get verification from the database.</p>
    <li>SelectConstituency</li>
        <p> This activity displays various constituency from where the user can vote and the further activities also depend on what the user selects.</p>
    <li> Voting</li>
        <p> Here the various parties are shown in the constituency that the user selected in previous class.</p>
    <li>Result</li>
        <p> This activity displays the result that you have voted for which party and what is the current result of the election.</p>
    
</ul>

<h3>Screenshots:</h2>
    <p>Login Screen</p>
    <a href="https://ibb.co/nP4SpK"><img src="https://preview.ibb.co/mzCrGz/1.png" alt="1" border="0" height="430" width="250"></a>
    <p>Constituency Screen</p>
    <a href="https://ibb.co/bwZSpK"><img src="https://preview.ibb.co/gDwwie/2a.png" alt="2a" border="0" height="430" width="250"></a>
    <p>Constituency disabled Screen</p>
    <a href="https://ibb.co/fieGie"><img src="https://preview.ibb.co/cWUtUK/2b.png" alt="2b" border="0" height="430" width="250"></a>
    <p>Voting Screen</p>
    <a href="https://ibb.co/hf1wie"><img src="https://preview.ibb.co/e6hf9K/3.png" alt="3" border="0" height="430" width="250"></a>
    <p>Result Screen</p>
    <a href="https://ibb.co/dDDWGz"><img src="https://preview.ibb.co/iVa09K/4.png" alt="4" border="0" height="430" width="250"></a>
    
   
</body>
</html>