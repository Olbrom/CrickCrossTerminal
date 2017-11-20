import java.util.Arrays;
import java.util.Scanner;

public class Game 	
{
	boolean koniecGry = false;
	char[][] plansza = new char [3][3];
	char kolko = 'o';
	char krzyzyk = 'x';
	char zwyciesca;
	char czyjaTura = kolko;
	
	Scanner inputScanner = new Scanner(System.in);
	
	public boolean getKoniecGry()
	{
		return koniecGry;
	}
	
	public void setKoniecGry(boolean koniecGry)
	{
		this.koniecGry = koniecGry;
	}
	
	public char getCzyjaTura()
	{
		return czyjaTura;
	}
	
	public void setCzyjaTura(char czyjaTura)
	{
		this.czyjaTura = czyjaTura;
	}
	
	public void zbudujPlansze() //done
	{
		for(char[] row : plansza)
        {
            Arrays.fill(row, ' ');     
        }
	}
	
	public void narysujPlansze() //done
	{
		 for (int i = 0; i < plansza.length; i++)
	        {
	            for(int j = 0; j < plansza[i].length; j++)
	            {
	                System.out.print("|" + plansza[i][j] + "|");
	            }
	            System.out.println();
	        }
	}
	
	public void nastepnyRuch()
	{
		int wspolrzednaX = 4;
		int wspolrzednaY = 4;
		System.out.println("Graczu '" + czyjaTura + "' Twoj ruch");
		System.out.println("Podaj wspó³rzêdn¹ X (od 1 do 3): ");
		
		
		while(wspolrzednaX > 3 || wspolrzednaX < 1)
			{
				wspolrzednaX = inputScanner.nextInt();	
			}
		wspolrzednaX--;
		
		System.out.println("Podaj wspó³rzêdn¹ Y (od 1 do 3): ");
		while(wspolrzednaY > 3 || wspolrzednaY < 1)
			{
				wspolrzednaY = inputScanner.nextInt();	
			}
		wspolrzednaY--;
		
		if((char)plansza[wspolrzednaY][wspolrzednaX] == kolko || (char)plansza[wspolrzednaY][wspolrzednaX] == krzyzyk)
			{
				System.out.println("Miejsce zajête!");
			}
		else
			{
				plansza[wspolrzednaY][wspolrzednaX] = czyjaTura;
				czyKoniecGry(czyjaTura);
				zmianaTury();
				
		}
	}

	public void zmianaTury()
	{
		if((char)czyjaTura == (char)kolko)
			{
				czyjaTura = krzyzyk;
			}
		else if((char)czyjaTura == (char)krzyzyk)
			{
				czyjaTura = kolko;
			}
	}
	
	public void czyKoniecGry(char czyjRuch)
	{
		for(int y = 0; y < 3; y++)
			{
				if(plansza[y][0] == czyjRuch && plansza[y][1] == czyjRuch && plansza [y][2] == czyjRuch)
					{
						System.out.println("Gratulacje! Wygra³ gracz: " + czyjRuch);
						setKoniecGry(true);
					}
			}
		for(int x = 0; x < 3; x++)
			{
				if(plansza[0][x] == czyjRuch && plansza[1][x] == czyjRuch && plansza [2][x] == czyjRuch)
					{
					System.out.println("Gratulacje! Wygra³ gracz: " + czyjRuch);
					setKoniecGry(true);
					}
			}
		
		if(plansza[0][0] == czyjRuch && plansza[1][1] == czyjRuch && plansza [2][2] == czyjRuch)
			{
				System.out.println("Gratulacje! Wygra³ gracz: " + czyjRuch);
				setKoniecGry(true);
			}
		
		if(plansza[0][2] == czyjRuch && plansza[1][1] == czyjRuch && plansza [2][0] == czyjRuch)
			{
				System.out.println("Gratulacje! Wygra³ gracz: " + czyjRuch);
				setKoniecGry(true);
			}	
	}
	
	
}