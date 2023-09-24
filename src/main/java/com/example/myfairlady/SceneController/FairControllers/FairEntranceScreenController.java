package com.example.myfairlady.SceneController.FairControllers;

import com.example.myfairlady.UtilityClasses.ScreenGeneral;

import java.io.IOException;

public class FairEntranceScreenController {

    public void StoreManagementButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairStoresScreenLocation);

    }

    public void StatsButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairStatsScreenLocation);

    }

    public void SettingsButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairSettingsScreenLocation);

    }

}
