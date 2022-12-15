namespace Laboratoire___3
{
    public class DessinAnimé : Série
    {
        #region attributes
        private int ageCiblé;
        #endregion
        
        #region constructor
        public DessinAnimé(string titre, int durée, string titreSérie, int numéroEpiosde, int ageCiblé) : base(titre,
            durée, titreSérie, numéroEpiosde)
        {
            this.ageCiblé = ageCiblé;
        }
        #endregion

        public new string Présentation()
        {
            return "Enfant de " + ageCiblé + " ans : " + titre + " (" + titreSérie + " numéro " + numéroEpisode + ")";
        }
    }
}