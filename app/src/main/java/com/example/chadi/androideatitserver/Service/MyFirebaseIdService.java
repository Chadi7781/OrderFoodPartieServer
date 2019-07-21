package com.example.chadi.androideatitserver.Service;

import com.example.chadi.androideatitserver.Common.Common;
import com.example.chadi.androideatitserver.Model.Token;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        updateToServer(refreshedToken);
    }

    private void updateToServer(String refreshedToken) {
        FirebaseDatabase db =FirebaseDatabase.getInstance();
        DatabaseReference tokens = db.getReference("Tokens");

        Token data = new Token(refreshedToken ,true);//ebecayse this is server side, this variable need change to true
        tokens.child(Common.currentUser.getPhone()).setValue(data);
    }
}
