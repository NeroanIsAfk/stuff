using System;

namespace Laboratoire___3
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Emission e1 = new Emission("Motus", 50);
            Emission e2 = new Emission("Des chiffres et des lettres", 45);
            Film f1 = new Film("Bilbo the Hobbit", 182, "fantastique");
            Film f2 = new Film("Le bon, la brute et le truand", 178, "western");
            Série s1 = new Série("Monsters", 47, "The Walking Dead", 801);
            Série s2 = new Série("The Interrogation", 52, "Designated Survivor", 6);
            DessinAnimé da1 = new DessinAnimé("Simprovised", 24, "Simpsons", 2721, 
                16);
            DessinAnimé da2 = new DessinAnimé("Droids in Distress", 22, "Star Wars Rebels", 3, 8);
            Console.WriteLine(UtilTV.AfficheProgamme(e1, e2, e2, f1, f2, s1, s2, da1, da2));
            Console.WriteLine("....");
            UtilTV.PrésenteDA(da1, da2);
        }
    }
}