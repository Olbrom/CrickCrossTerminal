package olbrom;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    // TODO JBODZIOC, 20.11.2017: dodaj accessory - wszystkie atrybuty maja miec accessor private np private boolean koniecGry;
    // po to robisz getery i setery zeby NIE MOZNA bylo sie dostac do zmiennych game.koniecGry; google - enkapsulacja
    boolean koniecGry = false;
    char[][] plansza = new char[3][3];
    char kolko = 'o'; // TODO JBODZIOC, 21.11.2017: to powinno byc final static, ta wartosc nie moze sie nigdy zmienic
    char krzyzyk = 'x'; // TODO JBODZIOC, 21.11.2017: to powinno byc final static, ta wartosc nie moze sie nigdy zmienic
    char zwyciesca; // TODO JBODZIOC, 21.11.2017: zwyciesca xDDDD
    char czyjaTura = kolko;
    
    Scanner inputScanner = new Scanner(System.in);

    // TODO JBODZIOC, 20.11.2017: te wszystkie rzeczy powyzej powinny byc tylko zadeklarowane, powinienes stworzyc domyslny konstruktor gdzie dopiero nadajesz im wartosci
    // to jest juz troche wyzszopoziomowy tip i nie zawsze ma on zastosowanie ale domyslny konstruktor i tak powinien tu byc

    public boolean getKoniecGry() {
        return koniecGry;
    }

    public void setKoniecGry(boolean koniecGry) {
        this.koniecGry = koniecGry;
    }

    public char getCzyjaTura() {
        return czyjaTura;
    }

    public void setCzyjaTura(char czyjaTura) {
        this.czyjaTura = czyjaTura;
    }

    // TODO JBODZIOC, 20.11.2017: ta metoda jest absolutnie zbedna :D
    public void zbudujPlansze() // done
    {
        for (char[] row : plansza) {
            // TODO JBODZIOC, 20.11.2017: magic number
            Arrays.fill(row, ' ');
        }
    }

    public void narysujPlansze() // done
    {
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                System.out.print("|" + plansza[i][j] + "|");
            }
            System.out.println();
        }
    }

    public void nastepnyRuch() {
        // TODO JBODZIOC, 20.11.2017: wypierdol te magic numbery do zmiennych globalnych np private final static int DEFAULT_VARIABLE_X = 4
        // TODO JBODZIOC, 20.11.2017: domyslna wartosc powinna byc -1, taka zasada ze -1 ogolnie oznacza ze cos poszlo nie tak, u ciebie to znaczy ze jest poza plansza
        
        int wspolrzednaX = 4;
        int wspolrzednaY = 4;
        // TODO JBODZIOC, 21.11.2017: wszystko co masz w sysoutach to magic numbery mimo ze nie wygladaja, wyjeb do zmiennych globalnych typu String
        System.out.println("Graczu '" + czyjaTura + "' Twoj ruch");
        System.out.println("Podaj wspó³rzêdn¹ X (od 1 do 3): ");
        // TODO JBODZIOC, 20.11.2017: wincyj magic numberow
        while (wspolrzednaX > 3 || wspolrzednaX < 1) {
            wspolrzednaX = inputScanner.nextInt();
        }
        // TODO JBODZIOC, 20.11.2017: czemu tak? nie latwiej byloby prosic od razu o liczby z przedzialu 0-2?
        wspolrzednaX--;

        System.out.println("Podaj wspó³rzêdn¹ Y (od 1 do 3): ");
        while (wspolrzednaY > 3 || wspolrzednaY < 1) {
            wspolrzednaY = inputScanner.nextInt();
        }
        wspolrzednaY--;
        // TODO JBODZIOC, 20.11.2017: czemu castujesz chara na chara? wtf?
        if ((char) plansza[wspolrzednaY][wspolrzednaX] == kolko || (char) plansza[wspolrzednaY][wspolrzednaX] == krzyzyk) {
            System.out.println("Miejsce zajête!");
        }
        else {
            plansza[wspolrzednaY][wspolrzednaX] = czyjaTura;
            czyKoniecGry(czyjaTura);
            zmianaTury();

        }
    }

    // TODO JBODZIOC, 20.11.2017: korzystasz z tej metody tylko w tej klasie, powinna byc private
    // TODO JBODZIOC, 20.11.2017: najlepiej zeby zwracala booleana a jej wywolanie wygladalo tak: czyjaTura = zmianaTury(); //enkapsulacja
    public void zmianaTury() {
        // TODO JBODZIOC, 20.11.2017: lol, znowu char na chara
        if ((char) czyjaTura == (char) kolko) {
            czyjaTura = krzyzyk;
        }
        // TODO JBODZIOC, 20.11.2017: czemu else if a nie else? masz inne mozliwosci niz kolko albo krzyzyk?
        // btw cala ta metoda mogla wygladac tak:
        // czyjaTura = czyjaTura == krzyzyk ? kolko : krzyzyk; //:D
        else if ((char) czyjaTura == (char) krzyzyk) {
            czyjaTura = kolko;
        }
    }

    // TODO JBODZIOC, 20.11.2017: tutaj moge sie przypierdolic do logiki, obecnie sprawdzasz kilka warunkow co nie ma znaczenia bo tobie wystarczy ze jeden bedzie spelniony
    // jak ktorys gracz spelni 2 warunki co jest mozliwe to 2x pojawi mu sie napis ze wygral
    // ja bym zmienil cala te metode zeby zwracala booleana i wyjebal booleana koniecGry
    // wtedy mialbys zamiast setow returny i bug by zniknal
    public void czyKoniecGry(char czyjRuch) {
     // TODO JBODZIOC, 20.11.2017: wincyj magic numberow
        for (int y = 0; y < 3; y++) {
            if (plansza[y][0] == czyjRuch && plansza[y][1] == czyjRuch && plansza[y][2] == czyjRuch) { // TODO JBODZIOC, 21.11.2017: cala te linijke moglbys wyjebac do osobnej metody, ogolnie jak masz warunek zlozony to jest dobra praktyka, zaznacz wszystko co masz w nawiasie i kliknij alt + shift + m :), powtorzyc dla wszystkich ponizszych
                System.out.println("Gratulacje! Wygra³ gracz: " + czyjRuch);
                setKoniecGry(true);
            }
        }
        for (int x = 0; x < 3; x++) {
            if (plansza[0][x] == czyjRuch && plansza[1][x] == czyjRuch && plansza[2][x] == czyjRuch) {
                System.out.println("Gratulacje! Wygra³ gracz: " + czyjRuch);
                setKoniecGry(true);
            }
        }

        // TODO JBODZIOC, 21.11.2017: ten warunek i ponizszy wykonuja dokladnie to samo, po co 2 ify jak mogl byc jeden?
        // zrob to w jednym ifie i wypierdol do metody tak jak napisalem powyzej
        if (plansza[0][0] == czyjRuch && plansza[1][1] == czyjRuch && plansza[2][2] == czyjRuch) {
            System.out.println("Gratulacje! Wygra³ gracz: " + czyjRuch);
            setKoniecGry(true);
        }

        if (plansza[0][2] == czyjRuch && plansza[1][1] == czyjRuch && plansza[2][0] == czyjRuch) {
            System.out.println("Gratulacje! Wygra³ gracz: " + czyjRuch);
            setKoniecGry(true);
        }
    }

}