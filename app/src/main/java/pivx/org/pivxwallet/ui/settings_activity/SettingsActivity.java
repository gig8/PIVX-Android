package pivx.org.pivxwallet.ui.settings_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pivx.org.pivxwallet.MainActivity;
import pivx.org.pivxwallet.R;
import pivx.org.pivxwallet.ui.pincode_activity.PincodeActivity;
import pivx.org.pivxwallet.ui.settings_backup_activity.SettingsBackupActivity;

/**
 * Created by Neoperol on 5/11/17.
 */

public class SettingsActivity extends MainActivity {
    Button buttonBackup;
    Button buttonRestore;
    Button buttonChange;
    Button buttonCurrency;
    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        getLayoutInflater().inflate(R.layout.fragment_settings, frameLayout);
        setTitle("Settings");

        // Open Backup Wallet
        pivxModule.createWallet();
        buttonBackup = (Button) findViewById(R.id.btn_backup_wallet);
        buttonBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), SettingsBackupActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // to check current activity in the navigation drawer
        navigationView.getMenu().getItem(2).setChecked(true);
    }
}
