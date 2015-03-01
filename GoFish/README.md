<h1>Go Fish!</h1>
Go Fish! is a console based program for the card game. The user and the program take turns in asking each other for cards. If the requested card is not in the opponent's hand, it is drawn from the deck. Once a book is complete (set of four cards of the same kind), it is put down. The player with the most number of books completed by the end of the game is then declared the winner.
<h2>Getting Started</h2>
Cards are randomized and shuffled into three groups: Human's hand, PC's hand and the Deck. Both players start with 7 cards each. Upon initialization, the program outputs user's starting cards.
<pre>GoFish!
Dealing cards...
Player's deck: [H2, DT, S9, H6, S4, SQ, D6] // 7 </pre>
Player's cards are indicated inside the array []. The number at the end of the line (after the "//") indicates the current number of cards the player has in his/her hand.
<h2>Playing the game</h2>
During the user's turn, the program will ask for an input of a requested card.
<pre>Ask opponent for card:   </pre>
It will then automatically search the opponent's hand for the card. If the opponent does not have the card in its hand, a card from the deck will be automatically added to the player's hand. The human and the PC will take turns in requesting for cards until the game is over. When the deck runs out of cards, a random card will be removed from the opponent's hand if the requested card is not available.
The user's hand and books dropped will automatically be logged in the console after each turn. It will look like this:
<pre>Player's deck: [H2, DT, S9, H6, S4, SQ, D6, S6] //8
Player's books: []//0</pre>
<h2>Forming and dropping books</h2>
A book is a complete set of cards of the same kind. The program scans the user/PC's hand after every turn for complete books. Once found, completed books are "dropped" and cards are removed from the hand.
<h2>How to win</h2>
To win the game, the player must have more books dropped than his/her opponent. The counting of books are auomated upon reaching the end of the game and the winner is declared.
<h2>Exiting the program</h2>
The program will automatically exit after the game is finished. If the user wants to quit in the middle of the game, simply hit Ctrl+C to terminate the program.
<h3>Card code</h3>
For this program, cards are defined using a combination of two characters. It follows a format of "Suit"+"Kind". For example, a 9 of Hearts is H9 while a 6 of diamonds is D6. The following table lists down the characters assigned for each specific suit/kind.
<h4>Suit</h4>
<table>
  <tr><td>Code</td><td>Suit</td></tr>
  <tr><td>D</td><td>Diamond</td></tr>
  <tr><td>H</td><td>Heart</td></tr>
  <tr><td>S</td><td>Spade</td></tr>
  <tr><td>C</td><td>Club</td></tr>
</table>
<h4>Kind</h4>
<table>
  <tr><td>Code</td><td>Kind</td></tr>
  <tr><td>2</td><td>2</td></tr>
  <tr><td>3</td><td>3</td></tr>
  <tr><td>4</td><td>4</td></tr>
  <tr><td>5</td><td>5</td></tr>
  <tr><td>6</td><td>6</td></tr>
  <tr><td>7</td><td>7</td></tr>
  <tr><td>8</td><td>8</td></tr>
  <tr><td>9</td><td>9</td></tr>
  <tr><td>T</td><td>10</td></tr>
  <tr><td>J</td><td>Jack</td></tr>
  <tr><td>Q</td><td>Queen</td></tr>
  <tr><td>K</td><td>King</td></tr>
  <tr><td>A</td><td>Ace</td></tr>
</table>

