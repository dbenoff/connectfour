# connectfour

Build with maven, then execute the bootable jar like so: java -jar connectfour-1.0-SNAPSHOT.jar

Start the game by calling /start?player1<player1name>&player2=<player2name>, which returns a game ID.

Play the game by calling /move?gameId=g=<gameId>&playerName=<playerName>&column=<specify column 0-6>
 
If the player has connected 4 pieces, /move returns true, otherwise false and the game continues.