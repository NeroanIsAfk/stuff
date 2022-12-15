namespace Laboratoire___3
{
    public class Série : Emission
    {
        #region attributes
        protected string titreSérie;
        protected int numéroEpisode;
        #endregion
        
        #region constructor
        public Série(string titre, int durée, string titreSérie, int numéroEpisode) : base(titre, durée)
        {
            this.titreSérie = titreSérie;
            this.numéroEpisode = numéroEpisode;
        }
        #endregion

        public override string Présentation()
        {
            return titreSérie + " : " + base.Présentation();
        }
    }
}