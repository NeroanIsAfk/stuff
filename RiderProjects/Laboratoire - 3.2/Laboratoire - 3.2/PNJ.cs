using System.Runtime.CompilerServices;
using System.Xml.Schema;

namespace Laboratoire___3._2
{
    public class PNJ : Créature
    {
        #region constructor
        public PNJ(string nom, int pvMax, int pv, string faction) : base(nom, pvMax, pv)
        {
            Faction = faction;
        }

        public PNJ(string nom, int pvMax, string faction) : base(nom, pvMax, pvMax)
        {
            Faction = faction;
        }
        #endregion
        public string Faction { get; set; }
    }
}