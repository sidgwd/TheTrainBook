package trainboook.hack.com.thetrainbook.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.stfalcon.chatkit.messages.MessageHolders;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import de.hdodenhof.circleimageview.CircleImageView;
import trainboook.hack.com.thetrainbook.Customs.DemoMessagesActivity;
import trainboook.hack.com.thetrainbook.Customs.IncomingVoiceMessageViewHolder;
import trainboook.hack.com.thetrainbook.Customs.Message;
import trainboook.hack.com.thetrainbook.Customs.MessagesFixtures;
import trainboook.hack.com.thetrainbook.Customs.OutcomingVoiceMessageViewHolder;
import trainboook.hack.com.thetrainbook.R;
import trainboook.hack.com.thetrainbook.Util.AppConfig;


public class GroupActivity extends DemoMessagesActivity implements OnMapReadyCallback , MessageInput.InputListener,
        MessageInput.AttachmentsListener,
        MessageHolders.ContentChecker<Message>,
        DialogInterface.OnClickListener {
    private static final byte CONTENT_TYPE_VOICE = 1;

    SupportMapFragment mapFragment;
    private MessagesList messagesList;
    ImageView imgvMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
///tool bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        imgvMap= findViewById(R.id.imgvMap);

        imgvMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GroupActivity.this, MapDetailActivity.class);
//                ActivityOptionsCompat options = ActivityOptionsCompat.
//                        makeSceneTransitionAnimation(GroupActivity.this,
//                                mapFragment,
//                                AppConfig.TRANSITION_PROFILE_PIC);
                startActivity(intent);
            }
        });

        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle("The Explorers");
        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.white));
        ///

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        this.messagesList = (MessagesList) findViewById(R.id.messagesList);
        initAdapter();

        MessageInput input = (MessageInput) findViewById(R.id.input);
        input.setInputListener(this);
        input.setAttachmentsListener(this);

    }

    @Override
    public boolean onSubmit(CharSequence input) {
        super.messagesAdapter.addToStart(
                MessagesFixtures.getTextMessage(input.toString()), true);
        return true;
    }

    @Override
    public void onAddAttachments() {
        new AlertDialog.Builder(this)
                .setItems(R.array.view_types_dialog, this)
                .show();
    }

    @Override
    public boolean hasContentFor(Message message, byte type) {
        switch (type) {
            case CONTENT_TYPE_VOICE:
                return message.getVoice() != null
                        && message.getVoice().getUrl() != null
                        && !message.getVoice().getUrl().isEmpty();
        }
        return false;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                messagesAdapter.addToStart(MessagesFixtures.getImageMessage(), true);
                break;
            case 1:
                messagesAdapter.addToStart(MessagesFixtures.getVoiceMessage(), true);
                break;
        }
    }

    private void initAdapter() {
        MessageHolders holders = new MessageHolders()
                .registerContentType(
                        CONTENT_TYPE_VOICE,
                        IncomingVoiceMessageViewHolder.class,
                        R.layout.item_custom_incoming_voice_message,
                        OutcomingVoiceMessageViewHolder.class,
                        R.layout.item_custom_outcoming_voice_message,
                        this);


        super.messagesAdapter = new MessagesListAdapter<>(super.senderId, holders, super.imageLoader);
        super.messagesAdapter.enableSelectionMode(this);
        super.messagesAdapter.setLoadMoreListener(this);
        this.messagesList.setAdapter(super.messagesAdapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(19.2270761,72.8562612))
                .title("Siddhesh Gawde[Boriwali]")
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.sid)))).setAnchor(0.5f, 1);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(19.2270761,72.8562612), 10));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(19.1511146,72.8517952))
                        .title("Lochana Chavan[Goregaon]")
                        .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.lochana)))).setAnchor(0.5f, 1);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(19.1511146,72.8517952), 12));
            }
        },10000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(19.0740174,72.8410076))
                        .title("Deepika[Santacruze]")
                        .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.deepika)))).setAnchor(0.5f, 1);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(19.0740174,72.8410076), 12));
            }
        },18000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(19.0547506,72.8406643))
                        .title("Manish Javlekar[Bandra]")
                        .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.manish)))).setAnchor(0.5f, 1);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(19.0547506,72.8406643), 13));
            }
        },25000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(19.0406709,72.8444034))
                        .title("Namrata gupta [Mahim]")
                        .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.namrata)))).setAnchor(0.5f, 1);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(19.0406709,72.8444034), 14));
            }
        },30000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(19.0276851,72.8481031))
                        .title("Nitin Poojari [Matunga]")
                        .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(R.drawable.nitin)))).setAnchor(0.5f, 1);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(19.0276851,72.8481031), 14));
            }
        },35000);



    }


    private Bitmap getMarkerBitmapFromView(@DrawableRes int resId) {

        View customMarkerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_custom_marker, null);
        CircleImageView markerImageView = (CircleImageView) customMarkerView.findViewById(R.id.profile_image);
        markerImageView.setImageResource(resId);
        customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        customMarkerView.layout(0, 0, customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight());
        customMarkerView.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = customMarkerView.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        customMarkerView.draw(canvas);
        return returnedBitmap;
    }
}