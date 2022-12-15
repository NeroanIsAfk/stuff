namespace Laboratoire___3
{
    public class Film : Emission
    {
        #region attributes
        private string genre;
        #endregion
        
        #region constructor
        public Film(string titre, int durée, string genre) : base(titre, durée)
        {
            this.genre = genre;
        }
        #endregion

        public override string Présentation()
        {
            return base.Présentation() + ", " + genre;
        }
    }
}