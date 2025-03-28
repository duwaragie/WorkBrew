import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workbrew.CafeData
import com.example.workbrew.R

class CafeAdapter(private val cafeList: List<CafeData>) :
    RecyclerView.Adapter<CafeAdapter.CafeViewHolder>() {

    class CafeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cafeImage: ImageView = itemView.findViewById(R.id.cafeImage)
        val cafeName: TextView = itemView.findViewById(R.id.cafeName)
        val cafeRating: TextView = itemView.findViewById(R.id.cafeRating)
        val cafeLocation: TextView = itemView.findViewById(R.id.cafeLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cafe_item_layout, parent, false)
        return CafeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {
        val cafe = cafeList[position]
        holder.cafeImage.setImageResource(cafe.imageResourceId)
        holder.cafeName.text = cafe.name
        holder.cafeRating.text = cafe.rating
        holder.cafeLocation.text = cafe.location
    }

    override fun getItemCount() = cafeList.size
}