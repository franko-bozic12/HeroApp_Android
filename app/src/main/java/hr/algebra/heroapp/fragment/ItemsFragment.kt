package hr.algebra.heroapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hr.algebra.heroapp.R
import hr.algebra.heroapp.adapter.ItemAdapter
import hr.algebra.heroapp.databinding.FragmentItemsBinding
import hr.algebra.heroapp.framework.fetchItems
import hr.algebra.heroapp.model.Item

class ItemsFragment : Fragment() {

    private lateinit var items: MutableList<Item>
    private lateinit var binding: FragmentItemsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        items = requireContext().fetchItems()
        binding = FragmentItemsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvItems.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ItemAdapter(requireContext(), items)
        }
    }

}