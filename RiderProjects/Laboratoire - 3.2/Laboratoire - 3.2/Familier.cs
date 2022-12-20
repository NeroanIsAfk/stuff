namespace Laboratoire___3._2
{
    public class Familier : PNJ, ICompagnon
    {
        #region attributes
        private int prix;
        #endregion
        
        #region constructor
        public Familier(string nom, string description, int prix) : base(nom,1, 1,
            "alliés")
        {
            Description = description;
            Prix = prix;
        }
        #endregion
        public string Description { get; set; }

        public int Prix
        {
            get
            {
                return prix;
            }
            set
            {
                if (value < 0)
                {
                    prix = 0;
                }
                else
                {
                    prix = value;
                }
            }
        }

        public int PrixAchat { get; }
        
        public int CoûtQuotidien { get; }

        public new int Pv
        {
            get
            {
                return pv;
            }
            set
            {
                pv = 1;
            }
        }
    }
} 