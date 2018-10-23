package com.marcusac.dk.racketstats.Model;

public class SetStats {

    //Serv stats
    private int firstServAce;
    private int secondServAce;
    private int firstServiceWinner;
    private int secondServiceWinner;
    private int firstServInPlay;
    private int secondServInPlay;
    private int firstServFootFault;
    private int secondServFootFault;
    private int doubleFault;

    //forhand Winner stats
    private int forhandBaselineWinner;
    private int forhandDropShotWinner;
    private int forhandSmashWinner;
    private int forhandVolleyWinner;
    private int forhandLobWinner;
    private int forhandAppoachWinner;
    private int forhandReturnWinner;

    //forhand Unforced Error
    private int forhandBaselineUnforcedError;
    private int forhandDropShotUnforcedError;
    private int forhandSmashUnforcedError;
    private int forhandVolleyUnforcedError;
    private int forhandLobUnforcedError;
    private int forhandAppoachUnforcedError;
    private int forhandReturnUnforcedError;

    //forhand Forced Errors
    private int forhandBaselineForcedError;
    private int forhandDropShotForcedError;
    private int forhandSmashForcedError;
    private int forhandVolleyForcedError;
    private int forhandLobForcedError;
    private int forhandAppoachForcedError;
    private int forhandReturnForcedError;

    //backhand Winner stats
    private int backhandBaselineWinner;
    private int backhandDropShotWinner;
    private int backhandSmashWinner;
    private int backhandVolleyWinner;
    private int backhandLobWinner;
    private int backhandAppoachWinner;
    private int backhandReturnWinner;

    //backhand Forced Errors
    private int backhandBaselineForcedError;
    private int backhandDropShotForcedError;
    private int backhandSmashForcedError;
    private int backhandVolleyForcedError;
    private int backhandLobForcedError;
    private int backhandAppoachForcedError;
    private int backhandReturnForcedError;

    //backhand Unforced Error
    private int backhandBaselineUnforcedError;
    private int backhandDropShotUnforcedError;
    private int backhandSmashUnforcedError;
    private int backhandVolleyUnforcedError;
    private int backhandLobUnforcedError;
    private int backhandAppoachUnforcedError;
    private int backhandReturnUnforcedError;

    public SetStats(int firstServAce,
                    int secondServAce,
                    int firstServiceWinner,
                    int secondServiceWinner,
                    int firstServInPlay,
                    int secondServInPlay,
                    int firstServFootFault,
                    int secondServFootFault,
                    int doubleFault,
                    int forhandBaselineWinner,
                    int forhandDropShotWinner,
                    int forhandSmashWinner,
                    int forhandVolleyWinner,
                    int forhandLobWinner,
                    int forhandAppoachWinner,
                    int forhandReturnWinner,
                    int forhandBaselineUnforcedError,
                    int forhandDropShotUnforcedError,
                    int forhandSmashUnforcedError,
                    int forhandVolleyUnforcedError,
                    int forhandLobUnforcedError,
                    int forhandAppoachUnforcedError,
                    int forhandReturnUnforcedError,
                    int forhandBaselineForcedError,
                    int forhandDropShotForcedError,
                    int forhandSmashForcedError,
                    int forhandVolleyForcedError,
                    int forhandLobForcedError,
                    int forhandAppoachForcedError,
                    int forhandReturnForcedError,
                    int backhandBaselineWinner,
                    int backhandDropShotWinner,
                    int backhandSmashWinner,
                    int backhandVolleyWinner,
                    int backhandLobWinner,
                    int backhandAppoachWinner,
                    int backhandReturnWinner,
                    int backhandBaselineForcedError,
                    int backhandDropShotForcedError,
                    int backhandSmashForcedError,
                    int backhandVolleyForcedError,
                    int backhandLobForcedError,
                    int backhandAppoachForcedError,
                    int backhandReturnForcedError,
                    int backhandBaselineUnforcedError,
                    int backhandDropShotUnforcedError,
                    int backhandSmashUnforcedError,
                    int backhandVolleyUnforcedError,
                    int backhandLobUnforcedError,
                    int backhandAppoachUnforcedError,
                    int backhandReturnUnforcedError) {
        this.firstServAce = firstServAce;
        this.secondServAce = secondServAce;
        this.firstServiceWinner = firstServiceWinner;
        this.secondServiceWinner = secondServiceWinner;
        this.firstServInPlay = firstServInPlay;
        this.secondServInPlay = secondServInPlay;
        this.firstServFootFault = firstServFootFault;
        this.secondServFootFault = secondServFootFault;
        this.doubleFault = doubleFault;
        this.forhandBaselineWinner = forhandBaselineWinner;
        this.forhandDropShotWinner = forhandDropShotWinner;
        this.forhandSmashWinner = forhandSmashWinner;
        this.forhandVolleyWinner = forhandVolleyWinner;
        this.forhandLobWinner = forhandLobWinner;
        this.forhandAppoachWinner = forhandAppoachWinner;
        this.forhandReturnWinner = forhandReturnWinner;
        this.forhandBaselineUnforcedError = forhandBaselineUnforcedError;
        this.forhandDropShotUnforcedError = forhandDropShotUnforcedError;
        this.forhandSmashUnforcedError = forhandSmashUnforcedError;
        this.forhandVolleyUnforcedError = forhandVolleyUnforcedError;
        this.forhandLobUnforcedError = forhandLobUnforcedError;
        this.forhandAppoachUnforcedError = forhandAppoachUnforcedError;
        this.forhandReturnUnforcedError = forhandReturnUnforcedError;
        this.forhandBaselineForcedError = forhandBaselineForcedError;
        this.forhandDropShotForcedError = forhandDropShotForcedError;
        this.forhandSmashForcedError = forhandSmashForcedError;
        this.forhandVolleyForcedError = forhandVolleyForcedError;
        this.forhandLobForcedError = forhandLobForcedError;
        this.forhandAppoachForcedError = forhandAppoachForcedError;
        this.forhandReturnForcedError = forhandReturnForcedError;
        this.backhandBaselineWinner = backhandBaselineWinner;
        this.backhandDropShotWinner = backhandDropShotWinner;
        this.backhandSmashWinner = backhandSmashWinner;
        this.backhandVolleyWinner = backhandVolleyWinner;
        this.backhandLobWinner = backhandLobWinner;
        this.backhandAppoachWinner = backhandAppoachWinner;
        this.backhandReturnWinner = backhandReturnWinner;
        this.backhandBaselineForcedError = backhandBaselineForcedError;
        this.backhandDropShotForcedError = backhandDropShotForcedError;
        this.backhandSmashForcedError = backhandSmashForcedError;
        this.backhandVolleyForcedError = backhandVolleyForcedError;
        this.backhandLobForcedError = backhandLobForcedError;
        this.backhandAppoachForcedError = backhandAppoachForcedError;
        this.backhandReturnForcedError = backhandReturnForcedError;
        this.backhandBaselineUnforcedError = backhandBaselineUnforcedError;
        this.backhandDropShotUnforcedError = backhandDropShotUnforcedError;
        this.backhandSmashUnforcedError = backhandSmashUnforcedError;
        this.backhandVolleyUnforcedError = backhandVolleyUnforcedError;
        this.backhandLobUnforcedError = backhandLobUnforcedError;
        this.backhandAppoachUnforcedError = backhandAppoachUnforcedError;
        this.backhandReturnUnforcedError = backhandReturnUnforcedError;
    }

    public SetStats() {}


    public int getFirstServAce() {
        return firstServAce;
    }

    public void setFirstServAce(int firstServAce) {
        this.firstServAce = firstServAce;
    }

    public int getSecondServAce() {
        return secondServAce;
    }

    public void setSecondServAce(int secondServAce) {
        this.secondServAce = secondServAce;
    }

    public int getFirstServiceWinner() {
        return firstServiceWinner;
    }

    public void setFirstServiceWinner(int firstServiceWinner) {
        this.firstServiceWinner = firstServiceWinner;
    }

    public int getSecondServiceWinner() {
        return secondServiceWinner;
    }

    public void setSecondServiceWinner(int secondServiceWinner) {
        this.secondServiceWinner = secondServiceWinner;
    }

    public int getFirstServInPlay() {
        return firstServInPlay;
    }

    public void setFirstServInPlay(int firstServInPlay) {
        this.firstServInPlay = firstServInPlay;
    }

    public int getSecondServInPlay() {
        return secondServInPlay;
    }

    public void setSecondServInPlay(int secondServInPlay) {
        this.secondServInPlay = secondServInPlay;
    }

    public int getFirstServFootFault() {
        return firstServFootFault;
    }

    public void setFirstServFootFault(int firstServFootFault) {
        this.firstServFootFault = firstServFootFault;
    }

    public int getSecondServFootFault() {
        return secondServFootFault;
    }

    public void setSecondServFootFault(int secondServFootFault) {
        this.secondServFootFault = secondServFootFault;
    }

    public int getDoubleFault() {
        return doubleFault;
    }

    public void setDoubleFault(int doubleFault) {
        doubleFault = doubleFault;
    }

    public int getForhandBaselineWinner() {
        return forhandBaselineWinner;
    }

    public void setForhandBaselineWinner(int forhandBaselineWinner) {
        this.forhandBaselineWinner = forhandBaselineWinner;
    }

    public int getForhandDropShotWinner() {
        return forhandDropShotWinner;
    }

    public void setForhandDropShotWinner(int forhandDropShotWinner) {
        this.forhandDropShotWinner = forhandDropShotWinner;
    }

    public int getForhandSmashWinner() {
        return forhandSmashWinner;
    }

    public void setForhandSmashWinner(int forhandSmashWinner) {
        this.forhandSmashWinner = forhandSmashWinner;
    }

    public int getForhandVolleyWinner() {
        return forhandVolleyWinner;
    }

    public void setForhandVolleyWinner(int forhandVolleyWinner) {
        this.forhandVolleyWinner = forhandVolleyWinner;
    }

    public int getForhandLobWinner() {
        return forhandLobWinner;
    }

    public void setForhandLobWinner(int forhandLobWinner) {
        this.forhandLobWinner = forhandLobWinner;
    }

    public int getForhandAppoachWinner() {
        return forhandAppoachWinner;
    }

    public void setForhandAppoachWinner(int forhandAppoachWinner) {
        this.forhandAppoachWinner = forhandAppoachWinner;
    }

    public int getForhandReturnWinner() {
        return forhandReturnWinner;
    }

    public void setForhandReturnWinner(int forhandReturnWinner) {
        this.forhandReturnWinner = forhandReturnWinner;
    }

    public int getForhandBaselineUnforcedError() {
        return forhandBaselineUnforcedError;
    }

    public void setForhandBaselineUnforcedError(int forhandBaselineUnforcedError) {
        this.forhandBaselineUnforcedError = forhandBaselineUnforcedError;
    }

    public int getForhandDropShotUnforcedError() {
        return forhandDropShotUnforcedError;
    }

    public void setForhandDropShotUnforcedError(int forhandDropShotUnforcedError) {
        this.forhandDropShotUnforcedError = forhandDropShotUnforcedError;
    }

    public int getForhandSmashUnforcedError() {
        return forhandSmashUnforcedError;
    }

    public void setForhandSmashUnforcedError(int forhandSmashUnforcedError) {
        this.forhandSmashUnforcedError = forhandSmashUnforcedError;
    }

    public int getForhandVolleyUnforcedError() {
        return forhandVolleyUnforcedError;
    }

    public void setForhandVolleyUnforcedError(int forhandVolleyUnforcedError) {
        this.forhandVolleyUnforcedError = forhandVolleyUnforcedError;
    }

    public int getForhandLobUnforcedError() {
        return forhandLobUnforcedError;
    }

    public void setForhandLobUnforcedError(int forhandLobUnforcedError) {
        this.forhandLobUnforcedError = forhandLobUnforcedError;
    }

    public int getForhandAppoachUnforcedError() {
        return forhandAppoachUnforcedError;
    }

    public void setForhandAppoachUnforcedError(int forhandAppoachUnforcedError) {
        this.forhandAppoachUnforcedError = forhandAppoachUnforcedError;
    }

    public int getForhandReturnUnforcedError() {
        return forhandReturnUnforcedError;
    }

    public void setForhandReturnUnforcedError(int forhandReturnUnforcedError) {
        this.forhandReturnUnforcedError = forhandReturnUnforcedError;
    }

    public int getForhandBaselineForcedError() {
        return forhandBaselineForcedError;
    }

    public void setForhandBaselineForcedError(int forhandBaselineForcedError) {
        this.forhandBaselineForcedError = forhandBaselineForcedError;
    }

    public int getForhandDropShotForcedError() {
        return forhandDropShotForcedError;
    }

    public void setForhandDropShotForcedError(int forhandDropShotForcedError) {
        this.forhandDropShotForcedError = forhandDropShotForcedError;
    }

    public int getForhandSmashForcedError() {
        return forhandSmashForcedError;
    }

    public void setForhandSmashForcedError(int forhandSmashForcedError) {
        this.forhandSmashForcedError = forhandSmashForcedError;
    }

    public int getForhandVolleyForcedError() {
        return forhandVolleyForcedError;
    }

    public void setForhandVolleyForcedError(int forhandVolleyForcedError) {
        this.forhandVolleyForcedError = forhandVolleyForcedError;
    }

    public int getForhandLobForcedError() {
        return forhandLobForcedError;
    }

    public void setForhandLobForcedError(int forhandLobForcedError) {
        this.forhandLobForcedError = forhandLobForcedError;
    }

    public int getForhandAppoachForcedError() {
        return forhandAppoachForcedError;
    }

    public void setForhandAppoachForcedError(int forhandAppoachForcedError) {
        this.forhandAppoachForcedError = forhandAppoachForcedError;
    }

    public int getForhandReturnForcedError() {
        return forhandReturnForcedError;
    }

    public void setForhandReturnForcedError(int forhandReturnForcedError) {
        this.forhandReturnForcedError = forhandReturnForcedError;
    }

    public int getBackhandBaselineWinner() {
        return backhandBaselineWinner;
    }

    public void setBackhandBaselineWinner(int backhandBaselineWinner) {
        this.backhandBaselineWinner = backhandBaselineWinner;
    }

    public int getBackhandDropShotWinner() {
        return backhandDropShotWinner;
    }

    public void setBackhandDropShotWinner(int backhandDropShotWinner) {
        this.backhandDropShotWinner = backhandDropShotWinner;
    }

    public int getBackhandSmashWinner() {
        return backhandSmashWinner;
    }

    public void setBackhandSmashWinner(int backhandSmashWinner) {
        this.backhandSmashWinner = backhandSmashWinner;
    }

    public int getBackhandVolleyWinner() {
        return backhandVolleyWinner;
    }

    public void setBackhandVolleyWinner(int backhandVolleyWinner) {
        this.backhandVolleyWinner = backhandVolleyWinner;
    }

    public int getBackhandLobWinner() {
        return backhandLobWinner;
    }

    public void setBackhandLobWinner(int backhandLobWinner) {
        this.backhandLobWinner = backhandLobWinner;
    }

    public int getBackhandAppoachWinner() {
        return backhandAppoachWinner;
    }

    public void setBackhandAppoachWinner(int backhandAppoachWinner) {
        this.backhandAppoachWinner = backhandAppoachWinner;
    }

    public int getBackhandReturnWinner() {
        return backhandReturnWinner;
    }

    public void setBackhandReturnWinner(int backhandReturnWinner) {
        this.backhandReturnWinner = backhandReturnWinner;
    }

    public int getBackhandBaselineForcedError() {
        return backhandBaselineForcedError;
    }

    public void setBackhandBaselineForcedError(int backhandBaselineForcedError) {
        this.backhandBaselineForcedError = backhandBaselineForcedError;
    }

    public int getBackhandDropShotForcedError() {
        return backhandDropShotForcedError;
    }

    public void setBackhandDropShotForcedError(int backhandDropShotForcedError) {
        this.backhandDropShotForcedError = backhandDropShotForcedError;
    }

    public int getBackhandSmashForcedError() {
        return backhandSmashForcedError;
    }

    public void setBackhandSmashForcedError(int backhandSmashForcedError) {
        this.backhandSmashForcedError = backhandSmashForcedError;
    }

    public int getBackhandVolleyForcedError() {
        return backhandVolleyForcedError;
    }

    public void setBackhandVolleyForcedError(int backhandVolleyForcedError) {
        this.backhandVolleyForcedError = backhandVolleyForcedError;
    }

    public int getBackhandLobForcedError() {
        return backhandLobForcedError;
    }

    public void setBackhandLobForcedError(int backhandLobForcedError) {
        this.backhandLobForcedError = backhandLobForcedError;
    }

    public int getBackhandAppoachForcedError() {
        return backhandAppoachForcedError;
    }

    public void setBackhandAppoachForcedError(int backhandAppoachForcedError) {
        this.backhandAppoachForcedError = backhandAppoachForcedError;
    }

    public int getBackhandReturnForcedError() {
        return backhandReturnForcedError;
    }

    public void setBackhandReturnForcedError(int backhandReturnForcedError) {
        this.backhandReturnForcedError = backhandReturnForcedError;
    }

    public int getBackhandBaselineUnforcedError() {
        return backhandBaselineUnforcedError;
    }

    public void setBackhandBaselineUnforcedError(int backhandBaselineUnforcedError) {
        this.backhandBaselineUnforcedError = backhandBaselineUnforcedError;
    }

    public int getBackhandDropShotUnforcedError() {
        return backhandDropShotUnforcedError;
    }

    public void setBackhandDropShotUnforcedError(int backhandDropShotUnforcedError) {
        this.backhandDropShotUnforcedError = backhandDropShotUnforcedError;
    }

    public int getBackhandSmashUnforcedError() {
        return backhandSmashUnforcedError;
    }

    public void setBackhandSmashUnforcedError(int backhandSmashUnforcedError) {
        this.backhandSmashUnforcedError = backhandSmashUnforcedError;
    }

    public int getBackhandVolleyUnforcedError() {
        return backhandVolleyUnforcedError;
    }

    public void setBackhandVolleyUnforcedError(int backhandVolleyUnforcedError) {
        this.backhandVolleyUnforcedError = backhandVolleyUnforcedError;
    }

    public int getBackhandLobUnforcedError() {
        return backhandLobUnforcedError;
    }

    public void setBackhandLobUnforcedError(int backhandLobUnforcedError) {
        this.backhandLobUnforcedError = backhandLobUnforcedError;
    }

    public int getBackhandAppoachUnforcedError() {
        return backhandAppoachUnforcedError;
    }

    public void setBackhandAppoachUnforcedError(int backhandAppoachUnforcedError) {
        this.backhandAppoachUnforcedError = backhandAppoachUnforcedError;
    }

    public int getBackhandReturnUnforcedError() {
        return backhandReturnUnforcedError;
    }

    public void setBackhandReturnUnforcedError(int backhandReturnUnforcedError) {
        this.backhandReturnUnforcedError = backhandReturnUnforcedError;
    }
}
