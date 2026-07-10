package com.ubayadev.final_thekupangs_anmpc.view
import android.widget.AdapterView
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener


@BindingAdapter("selectedItemPosition")
fun Spinner.setSelectedItemPosition(position: Int?) {
    if (position != null && selectedItemPosition != position) {
        setSelection(position)
    }
}


@InverseBindingAdapter(
    attribute = "selectedItemPosition"
)
fun Spinner.getSelectedItemPosition(): Int {
    return selectedItemPosition
}


@BindingAdapter("selectedItemPositionAttrChanged")
fun Spinner.setSelectedItemPositionListener(
    listener: InverseBindingListener?
) {

    if (listener == null) return

    onItemSelectedListener =
        object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: android.view.View?,
                position: Int,
                id: Long
            ) {
                listener.onChange()
            }

            override fun onNothingSelected(
                parent: AdapterView<*>?
            ) {

            }
        }
}