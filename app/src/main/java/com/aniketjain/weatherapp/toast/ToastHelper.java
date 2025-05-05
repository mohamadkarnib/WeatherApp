public class ToastHelper {
    public static void show(Context context, String message, @StyleRes int style) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);

        if (style != 0) {
            View view = toast.getView();
            view.setBackgroundResource(style);
            TextView text = view.findViewById(android.R.id.message);
            text.setTextColor(ContextCompat.getColor(context, R.color.white));
        }

        toast.show();
    }
}