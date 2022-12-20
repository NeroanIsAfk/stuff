using System;
using System.Text;

namespace Laboratoire___3._2
{
    public class Marchand : PNJ
    {
        public const int NB_MAX_COMPAGNONGS = 10;
        
        #region attributes
        private ICompagnon[] listeCompagnons = new ICompagnon[NB_MAX_COMPAGNONGS];
        #endregion
        
        #region constructor
        public Marchand(string nom, ICompagnon[] listeCompagnons) : base(nom, 10, 10, "commerçants")
        {
            this.listeCompagnons = listeCompagnons;
        }
        #endregion

        public void AjouterCompagnon(ICompagnon compagnon)
        {
            int i = 0;

            while (listeCompagnons[i] != null)
            {
                i++;
            }

            listeCompagnons[i] = compagnon;
        }

        public string AfficheOffre()
        {
            StringBuilder output = new StringBuilder();
            int i = 1;

            foreach (ICompagnon compagnonDisponible in listeCompagnons)
            {
                output.Append("(" + i + ") " + compagnonDisponible.Nom + " : " + compagnonDisponible.PrixAchat + " po");
                output.Append(" de plus" + compagnonDisponible + " po par jour");
            }

            return output.ToString();
        }
    }
}