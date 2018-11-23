
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Star Rating</title>
        <meta name="viewport" content="initial-scale=1,width=device-width">
        <link rel="stylesheet" type="text/css" href="/css/StarRating.css">
        <link rel="stylesheet" href="//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    </head>
    <body>
    	<h2>User: ${rating.user.alias}</h2>
		<h2>Cleanliness: ${rating.cleanliness}</h2>
		<h2>Food Quality: ${rating.foodQuality}</h2>
		<h2>Service: ${rating.service}</h2>
		<h2>Review: ${rating.description}</h2>
		<a href="/ratings/${rating.id}/edit">Edit</a>
    </body>
</html>