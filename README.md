# Die mächtige Readme der readmeichkeit.

Servus allerseits!

Hier ist erstmal die Previewversion der Aufgabe, was für euch in erster Linie wichtig ist sind
die java-files in main\java\thkoeln\algo\praktikumms1 (und Unterpackages). Die Klassen
Dijkstra und Network sind dabei von euch zu füllen/korrigieren.

Unittests sind in dieser Version nicht enthalten (Update: Doch), aber in der App.java seht ihr
einen simplen Ablauf der insgesamt folgenden Output auf der Konsole liefern sollte wenn alles
richtig implementiert wurde (Packt die toString Methoden am besten nicht an):

{}
{E=null:2147483647, B=null:2147483647, C=null:2147483647, D=null:2147483647, A=null:0}
{E=A:14, B=A:5, C=A:20, D=B:8, A=null:0}
Route: C:A: length = 20
Route: E:A: length = 14
Route: A:E: length = 14
[A, B, C, D, E]
[A:B:5, C:A:20, D:B:3, E:D:7, E:A:14]
3
[B, C, D, E]
[D:B:3, E:D:7]
[]
[]

Außerdem sind jetzt auch die Komponenten für MS2 enthalten, hier solltet ihr vor allem in der
AwesomePriorityQueue.java arbeiten (lest euch den Kommentar dort durch für mehr Infos darüber
was zu tun ist).

test