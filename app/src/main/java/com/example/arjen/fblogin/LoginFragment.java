package com.example.arjen.fblogin;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arjen.fblogin.Models.User;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment {

    LoginButton loginButton;
    TextView loginMessageTV;
    ProfilePictureView profilePictureView;

    private AccessTokenTracker tokenTracker;
    private ProfileTracker profileTracker;
    private CallbackManager mCallBackManager;

    private FacebookCallback<LoginResult> mCallBack = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken CurrentAccesToken = loginResult.getAccessToken();
            Profile CurrentProfile = Profile.getCurrentProfile();
            User userData = new User(CurrentProfile.getName(), CurrentProfile.getId());
            Snackbar.make(getView(), "Naam: " + userData.getUserName() + "Mail: " + userData.getUserMail(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
            //startActivity(new Intent(getActivity(), HomeActivity.class));
            displayWelcomeMessage(CurrentProfile);

        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {
            Snackbar.make(getView(), "Unable to login, try again later.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            Log.d("Failure", "" + error.toString());
        }
    };

    public LoginFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setHasOptionsMenu allows onCreateOptionsMenu in fragment
        //setHasOptionsMenu(true);

        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mCallBackManager = CallbackManager.Factory.create();
        tokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                displayWelcomeMessage(currentProfile);
            }
        };

        tokenTracker.startTracking();
        profileTracker.startTracking();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginButton = (LoginButton) view.findViewById(R.id.Login_Button);
        loginMessageTV = (TextView) view.findViewById(R.id.Login_Message);
        profilePictureView = (ProfilePictureView) view.findViewById(R.id.Profile_Picture);

        loginButton.setReadPermissions("public_profile", "user_friends");
        loginButton.setFragment(this);
        loginButton.registerCallback(mCallBackManager, mCallBack);
    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//
//        // Set new menu
//        inflater.inflate(R.menu.menu_main, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }

    @Override
    public void onResume() {
        super.onResume();
        Profile CurrentProfile = Profile.getCurrentProfile();
        displayWelcomeMessage(CurrentProfile);
    }

    @Override
    public void onStop() {
        super.onStop();
        tokenTracker.stopTracking();
        profileTracker.stopTracking();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallBackManager.onActivityResult(requestCode, resultCode, data);
    }


    public void displayWelcomeMessage(Profile CurrentProfile) { //TODO Rename updateProfile

        if (CurrentProfile != null) {
            loginMessageTV.setText("Welcome, " + CurrentProfile.getName());
            profilePictureView.setProfileId(CurrentProfile.getId());
        } else {
            loginMessageTV.setText("Please Login!");
            profilePictureView.setProfileId(null);
        }
        //FragmentTransaction ft = getFragmentManager().beginTransaction(); //refresh current fragment
        //ft.detach(this).attach(this).commit();
    }
}
