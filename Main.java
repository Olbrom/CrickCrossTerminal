package olbrom;

public class Main {
    // uwagi ogolne:
    
    // TODO JBODZIOC, 20.11.2017: PRZEDE WSZYSTKIM, staram sie pisac wszystko co mi lezy na sercu, nie wiem ile tego wyjdzie
    // nie zniechecaj sie bo i tak wyglada to spoko
    // jesli bedziesz chcial, to popraw to co pisalem, to naprawde niewielkie uwagi, a zdecydowanie poprawiaja clean code
    
    
    // TODO JBODZIOC, 20.11.2017: pls, zmien jezyk na angielski, nigdy nie programowalem po polsku i nigdy nie bede, Ty pewnie tez
    // nie :) nie uwazasz ze getKoniecGry() brzmi dziwnie?
    // TODO JBODZIOC, 20.11.2017: masz blad logiczny, iksy rosna w prawo czyli slusznie ale igreki rosna w dol, powinny isc w gore tak jak uklad wspolrzednych
    // TODO JBODZIOC, 20.11.2017: jak ktorys gracz wygra gre to moim zdaniem powinno jeszcze raz wydrukowac plansze z wynikiem
    
    // TODO JBODZIOC, 21.11.2017: teraz cos na potem, takie zadanie z gwiazdka :P nie musisz tego wiedziec ale sysouta sie nie stosuje, duzo lepszym rozwiazaniem jest logger, 
    // nie wiem czy ma sens uswiadamianie cie skoro i tak chcesz do tego dorobic widok ale to tak na przyszlosc
    // jak juz to bedziesz przerabial to mozesz rownie dobrze kazdego sysouta przerobic na wiadomosc z loggera
    
    public static void main(String[] args) {
        Game gra = new Game();

        gra.zbudujPlansze();
        // TODO JBODZIOC, 20.11.2017: pls no, zrobiles getter ale nie uzyles, gra.getKoniecGry()
        while (gra.koniecGry == false) {
            gra.narysujPlansze();
            gra.nastepnyRuch();
            gra.czyKoniecGry(gra.getCzyjaTura());
        }

    }
}