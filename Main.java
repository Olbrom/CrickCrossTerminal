public class Main
{
	public static void main (String[] args)
	{
		Game gra = new Game();
		
		gra.zbudujPlansze();
		while(gra.koniecGry == false)
		{
			gra.narysujPlansze();
			gra.nastepnyRuch();
			gra.czyKoniecGry(gra.getCzyjaTura());
		}
		
		
	}
}