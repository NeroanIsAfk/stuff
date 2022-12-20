using System;

namespace Laboratoire___3._2
{
    public class Créature
    {
        #region attributes
        protected string nom;
        protected int pv;
        protected int pvMax;
        #endregion
        
        #region constructor
        public Créature(string nom, int pvMax, int pv)
        {
            Nom = nom;
            this.pvMax = pvMax < 1 ? 1 : pvMax;
            Pv = pv;
        }

        public Créature(string nom, int pvMax) :
            this(nom, pvMax, pvMax) { }
        #endregion

        public string Nom
        {
            get
            {
                return String.IsNullOrEmpty(nom) ? "aucun nom" : nom;
            }
            set
            {
                nom = value;
            }
        }

        public int Pv
        {
            get
            {
                return pv;
            }
            set
            {
                pv = value;

                if (pv < 0)
                {
                    pv = 0;
                }

                if (pv > pvMax)
                {
                    pv = pvMax;
                }
            }
        }

        public double PourcentsPV
        {
            get
            {
                return ((double)pv / pvMax) * 100;
            }
        }

        public string Etat
        {
            get
            {
                return nom + " (" + pv + "/" + pvMax + " : " + PourcentsPV.ToString("F2") + ")" + (pv == 0 ? "- MORT" : "");
            }
        }
    }
}