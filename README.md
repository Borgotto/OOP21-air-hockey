###### OOP21-air-hockey

<!--- LINK UTILI:

https://github.com/akullpp/awesome-java

--->

**<h1 > Air hockey 🥏🥅</h1>**

[![compile](https://github.com/Borgotto/OOP21-air-hockey/actions/workflows/compile.yml/badge.svg)](https://github.com/Borgotto/OOP21-air-hockey/actions/workflows/compile.yml)

[![generate javadoc](https://github.com/Borgotto/OOP21-air-hockey/actions/workflows/generate-javadoc.yml/badge.svg)](https://github.com/Borgotto/OOP21-air-hockey/actions/workflows/generate-javadoc.yml)

[![Javadoc - borgotto.github.io/OOP21-air-hockey/](https://img.shields.io/badge/Javadoc-borgotto.github.io%2FOOP21--air--hockey%2F-f8981d)](https://borgotto.github.io/OOP21-air-hockey/)


L'obiettivo del progetto è quello di sviluppare un gioco simile a hockey da tavolo, chiamato anche air hockey.
Il giocatore comanderà un [piattino](https://en.wikipedia.org/wiki/Air_hockey#/media/File:Air_Hockey_Mallet.jpg) e dovrà cercare di fare gol nella rete avversaria protetta da un'AI anch'essa al controllo di un piattino.
La partita terminerà raggiunto un certo punteggio o alla chiusura dell'applicazione.

**<h3> Membri: </h3>**

- **Emanuele Borghini - emanuele.borghini@studio.unibo.it**
- **Edoardo La Greca - edoardo.lagreca@studio.unibo.it**
- **Francesca Lanzi - francesca.lanzi6@studio.unibo.it**
- **Pablo Sebastian Vargas Grateron - pablo.vargasgrateron@studio.unibo.it**

**<h3> Obbiettivi: </h3>**
Realizzare un gioco stile Air hockey da tavolo

| Funzionalità                                          |   Difficoltà stimata  |
| ----------------------------------------------------- | :-------------------: |
| Gestione logica di gioco                              | Media 😅              |
| Possibilità di pausare la partita                     | Facile 😊             |
| AI nemica di base                                     | Facile 😊             |
| Menù principale con opzioni varie                     | Media/Difficile 😨    |
| Gestione realistica delle collisioni                  | Media/Difficile 😨    |
| Salvare la partita per riprenderla successivamente    | Media/Difficile 😨    |
| Diverse arene di gioco                                | Media 😅              |
| <h4> Opzionali: </h4>                                 |                       |
| Achievement di gioco                                  | Media 😅              |
| Effetti speciali: scia e collisioni dischetto         | Media 😅              |
| Gestione dei progressi (es: sblocco skin)             | Media 😅              |
| Diverse difficoltà per l'AI nemica                    | Media/Difficile 😨    |
| Modalità di gioco multiplayer via lan                 | Difficile 🥵          |
| Porting su android con gestione input touch           | Difficile 🥵          |

**<h3> Challenge principali: </h3>**
- corretta separazione di GUI e logica di gioco
- utilizzare formati XML e Json per salvare e leggere dati su file
- corretta serializzazione della classe di logica
- ricercare, studiare e implementare una libreria esterna per gestire le collisioni
- sviluppare una AI primitiva e una più avanzata per l'avversario

**<h3> Suddivisione del lavoro: </h3>**
- **Emanuele Borghini**
  - Serializzare lo stato della partita con la possibilità di salvarla su file e riprenderla durante un'altra esecuzione
  - Menù principale con delle opzioni per creare una partita, cambiare look alla GUI e degli elementi di gioco
  - Creare un loader per il look degli elementi di gioco che verranno salvati in formato XML
- **Edoardo La Greca**
  - Possibilità di mettere in pausa e riprendere la partita
  - Diverse arene di gioco con diverse difficoltà per ogni arena
  - Modalità di gioco multiplayer via lan tramite lo scambio di messaggi
- **Francesca Lanzi**
  - Gestione logica di gioco, ovvero creazione di partita, punteggio, servizio del dischetto
  - Creazione della AI nemica di base e inclusione nella logica di gioco
  - Personalizzazione dell'esperienza di gioco tramite obiettivi sbloccati dinamicamente durante la partita
- **Pablo Sebastian Vargas Grateron**
  - Gestione realistica delle collisioni 2D tra gli elementi di gioco tramite una libreria di terze parti
  - Salvataggio dei progressi di gioco su file per renderli persistenti durante le diverse partite
