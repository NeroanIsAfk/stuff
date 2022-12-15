using System;

namespace Laboratoire___1
{
  internal class Program
  {
    public static void Main(string[] args)
    {
      Player neroan = new Player("Charlier", "Killian", new DateTime(2002, 8,7), true);
      Player neroan2 = new Player("Charlier", "Killian", new DateTime(2002, 8,7), false);

      Map map = new Map("Caverne", 7, 10, false);
      Map map2 = new Map("Forêt", 7, true);
      
      neroan.AddMap(map);
      neroan.AddMap(map2);
      Console.WriteLine(neroan.ListingMaps());

      Console.WriteLine(map2.Description());
    }
  }
}