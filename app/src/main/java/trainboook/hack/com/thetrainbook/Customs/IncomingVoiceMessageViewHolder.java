package trainboook.hack.com.thetrainbook.Customs;

import android.view.View;
import android.widget.TextView;

import com.stfalcon.chatkit.messages.MessageHolders;
import com.stfalcon.chatkit.utils.DateFormatter;

import trainboook.hack.com.thetrainbook.R;

/*
 * Created by troy379 on 05.04.17.
 */
public class IncomingVoiceMessageViewHolder
        extends MessageHolders.IncomingTextMessageViewHolder<Message> {

    private TextView tvDuration;
    private TextView tvTime;

    public IncomingVoiceMessageViewHolder(View itemView, Object payload) {
        super(itemView, payload);
        tvDuration = (TextView) itemView.findViewById(R.id.duration);
        tvTime = (TextView) itemView.findViewById(R.id.time);
    }

    @Override
    public void onBind(Message message) {
        super.onBind(message);
        tvDuration.setText(
                FormatUtils.getDurationString(
                        message.getVoice().getDuration()));
        tvTime.setText(DateFormatter.format(message.getCreatedAt(), DateFormatter.Template.TIME));
    }
}
