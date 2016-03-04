package rabbitescape.engine.logic;

import static rabbitescape.engine.util.WorldAssertions.assertWorldEvolvesLike;

import org.junit.Test;

public class TestDrowning
{
    @Test
    public void rabbits_drown_when_pipes_pump_water_on_them()
    {
        assertWorldEvolvesLike(
            "#P#" + "\n" +
            "# #" + "\n" +
            "#r#" + "\n" +
            "###",

            "#P#" + "\n" +
            "# #" + "\n" +
            "#|#" + "\n" +
            "###",

            "#P#" + "\n" +
            "#n#" + "\n" +
            "#?#" + "\n" +
            "###",

            "#P#" + "\n" +
            "#n#" + "\n" +
            "#|#" + "\n" + // Rabbits characters are displayed in preference to water.
            "###",

            "#P#" + "\n" +
            "#n#" + "\n" +
            "#N#" + "\n" + // There is no rabbit now, as it has drowned.
            "###"
        );
    }

    @Test
    public void rabbits_drown_on_slopes()
    {
        assertWorldEvolvesLike(
            "#  P#" + "\n" +
            "# r/ " + "\n" +
            "# /  " + "\n" +
            "#/   ",

            "#  P#" + "\n" +
            "#  $ " + "\n" +
            "# r  " + "\n" +
            "#/   ",

            "#  P#" + "\n" +
            "#  ? " + "\n" +
            "# /  " + "\n" +
            "#/   ",

            "# nP#" + "\n" +
            "# nn " + "\n" +
            "# %  " + "\n" +
            "#/   ",

            "# nP#" + "\n" +
            "# nN " + "\n" +
            "# n  " + "\n" +
            "#%   ",

            "# nP#" + "\n" +
            "#nnn " + "\n" +
            "#nn  " + "\n" +
            "#[   ",

            "# nP#" + "\n" +
            "#nnn " + "\n" +
            "#n$  " + "\n" +
            "#n   ",

            "# nP#" + "\n" +
            "#nn$ " + "\n" +
            "#nn  " + "\n" +
            "#n   ",

            "# nP#" + "\n" +
            "#nnn " + "\n" +
            "#nn  " + "\n" +
            "#N   "
        );
    }

    @Test
    public void rabbits_can_wade_through_rivers()
    {
        assertWorldEvolvesLike(
            "    P#" + "\n" +
            "r    #" + "\n" +
            "######",

            "    P#" + "\n" +
            " r>  #" + "\n" +
            "######",

            "    P#" + "\n" +
            "  r>n#" + "\n" +
            "######",

            "    P#" + "\n" +
            "   n>#" + "\n" +
            "######",

            "   nP#" + "\n" +
            "  nn?#" + "\n" +
            "######",

            "   nP#" + "\n" +
            " nn<n#" + "\n" +
            "######",

            "   nP#" + "\n" +
            "nn<nn#" + "\n" +
            "######",

            "   nP#" + "\n" +
            "n<nnn#" + "\n" +
            "######",

            "   nP#" + "\n" +
            "<nnnn#" + "\n" +
            "######"
        );
    }

    @Test
    public void bashing_can_cause_drowning()
    {
        assertWorldEvolvesLike(
            "# r  #" + "\n" +
            "# ####" + "\n" +
            "# \\PP#" + "\n" +
            "# b\\ #" + "\n" +
            "######",

            "#  r>#" + "\n" +
            "# ####" + "\n" +
            "# \\PP#" + "\n" +
            "# b\\ #" + "\n" +
            "######",

            "#   ?#" + "\n" +
            "# ####" + "\n" +
            "# \\PP#" + "\n" +
            "# bNn#" + "\n" +
            "######",

            "#  <j#" + "\n" +
            "# ####" + "\n" +
            "# nPP#" + "\n" +
            "# bnN#" + "\n" +
            "######",

            "# <j #" + "\n" +
            "# ####" + "\n" +
            "# nPP#" + "\n" +
            "# bNN#" + "\n" +
            "######",

            "#<j  #" + "\n" +
            "# ####" + "\n" +
            "# nPP#" + "\n" +
            "# bNN#" + "\n" +
            "######",

            "#j   #" + "\n" +
            "#f####" + "\n" +
            "#fNPP#" + "\n" +
            "# bNN#" + "\n" +
            "######",

            "#    #" + "\n" +
            "# ####" + "\n" +
            "#jNPP#" + "\n" +
            "#fbNN#" + "\n" +
            "######",

            "#    #" + "\n" +
            "# ####" + "\n" +
            "# NPP#" + "\n" +
            "#|bNN#" + "\n" +
            "######",

            "#    #" + "\n" +
            "# ####" + "\n" +
            "# NPP#" + "\n" +
            "#r>NN#" + "\n" +
            "######",

            "#    #" + "\n" +
            "# ####" + "\n" +
            "# NPP#" + "\n" +
            "# rKN#" + "\n" +
            "######",

            "#    #" + "\n" +
            "# ####" + "\n" +
            "# NPP#" + "\n" +
            "# r>N#" + "\n" +
            "######",

            "#    #" + "\n" +
            "# ####" + "\n" +
            "# NPP#" + "\n" +
            "#  NN#" + "\n" + // The rabbit has drowned.
            "######",

            // If the world was to continue after the death of the rabbit then
            // the water would flow to fill the space.
            "#    #" + "\n" +
            "# ####" + "\n" +
            "# NPP#" + "\n" +
            "# NNN#" + "\n" +
            "######"
        );
    }
}
