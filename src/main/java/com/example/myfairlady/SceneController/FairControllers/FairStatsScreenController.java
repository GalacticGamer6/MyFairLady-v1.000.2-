package com.example.myfairlady.SceneController.FairControllers;

import com.example.myfairlady.UtilityClasses.ScreenGeneral;

import java.io.IOException;

public class FairStatsScreenController {

    public void StoreManagementButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairStoresScreenLocation);

    }

    public void SettingsButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairSettingsScreenLocation);

    }

    public void EntranceManagementButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairEntranceScreenLocation);

    }
}
