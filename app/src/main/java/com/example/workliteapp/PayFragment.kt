
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workliteapp.CardAdapter
import com.example.workliteapp.CardItem
import com.example.workliteapp.R


class PayFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CardAdapter
    private lateinit var itemList: List<CardItem>


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        itemList = generateSampleData()
        adapter = CardAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    private fun generateSampleData(): List<CardItem> {
        val data = mutableListOf<CardItem>()
        for (i in 1..10) {
            data.add(CardItem("2024-04-$i", "09:00 AM - 05:00 PM", "Farming", "$100"))
        }
        return data
    }
}
