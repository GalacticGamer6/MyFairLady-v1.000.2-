package com.example.myfairlady.SceneController.FairControllers;

import com.example.myfairlady.UtilityClasses.ScreenGeneral;

import java.io.IOException;

public class FairSettingsScreenController {

    public void StoreManagementButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairStoresScreenLocation);

    }

    public void StatsButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairStatsScreenLocation);

    }


    public void EntranceManagementButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairEntranceScreenLocation);

    }
}
