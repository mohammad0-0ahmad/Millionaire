<!DOCTYPE html>
<html lang="en">
<head>
<?php 
//Adding the head tag content. This way is used because website have almost collective head tag. It is used as well with other collective page parts as the footer and navigation bar. 
include "parts/head.html";
?>
<link rel="stylesheet" href="css/high_score_style.css">
<script src="js/high-score.js"></script>
<title>High-score lista</title>
</head>
<body>
    <?php
    // Adding the navigationbar to the page.
     include "parts/nav.html";?>
    <!--page introduction (some information about this page.)-->
    <main>
    <div class="presentation-rulepage">
            <div class="introduction">
                <div class="intro-text">
                    <h1>
                        High-score lista
                    </h1>
                    <p>
                       Den här sidan visar en <a href="#high-score-list">high-score lista</a> där står en rigerster tillhör till alla spelare som har spelat.<br>
                       Varje rad visar en spelare uppgifter där står namnet,datumet,beloppet man fick och spelarenspoäng.<br>
                       Spelarenspoäng är beröende på hur snabbt svarar man på en fråga och på vilken fråga nådde sist under matchen.<br>
                       En spelare kan ha flera rader så vi recomenderar att använda riktiga namn om man vill visa sina score till dem andra.<br>
                       Den här sidan kan besökas lätt genom att skanna <a href="https://sv.wikipedia.org/wiki/QR-kod">QR koden</a> some står till vänster på "money check" som visas i slutet av matchen. 
                    </p>
                </div>
            </div>
            <div class="cover1">
                <div>
                    <img src="img/high-score.png" alt="" width="400" height="600">
                </div>
            </div>
        </div>
        <!--The page content (high score table)-->
        <div id="high-score-container">
    <table id="high-score-list">
        <!--table's head-->
        <thead>
            <tr>
                <th><i class="far fa-address-card"></i>Spelarensnamn</th>
                <th><i class="fas fa-coins"></i>beloppet</th>
                <th><i class="fas fa-star"></i>Spelarenspoäng</th>
                <th><i class="far fa-calendar-alt"></i>datum & tid</th>
        </tr>
        </thead>
        <tbody>
            <!-- table's content generates from js.js-->
        </tbody>
    </table>
    </div>
</main>
    <?php
        // Adding the footer to the page.
     include "parts/footer.html";?>
     <!-- include js that is related to navigation bar-->
    <script src="js/fun.js"></script>
</body>
<script>
    // call the method that show players data inside the table and make the table up to date every 3 seconds.
    document.onload = showHighScoreList();
    document.onload = setInterval(function(){
    showHighScoreList();
},3000);
</script>
</html>