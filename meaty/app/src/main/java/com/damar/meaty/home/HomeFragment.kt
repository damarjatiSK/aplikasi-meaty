package com.damar.meaty.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.damar.meaty.R
import com.damar.meaty.adapter.ListStoryAdapter
import com.damar.meaty.adapter.LoadingStateAdapter
import com.damar.meaty.databinding.FragmentHomeBinding
import com.damar.meaty.detail.DetailStoryActivity
import com.damar.meaty.detail.ViewModelFactory
import com.damar.meaty.local.Artikel
//import com.damar.meaty.detail.ViewModelFactory
import com.damar.meaty.login.LoginActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var beritaRecyclerView: RecyclerView
    private lateinit var beritaAdapter: BeritaAdapter
    private lateinit var artikelList: ArrayList<Artikel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        beritaRecyclerView = view.findViewById(R.id.b_RecyclerView)
        artikelList = createSampleArtikelList()
        beritaAdapter = BeritaAdapter(artikelList)

        beritaRecyclerView.layoutManager = LinearLayoutManager(context)
        beritaRecyclerView.adapter = beritaAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.story_list)
        setHasOptionsMenu(true)
    }

    private fun createSampleArtikelList(): ArrayList<Artikel> {
        val artikelList = ArrayList<Artikel>()
        artikelList.add(Artikel("Membuat Bakso Dari Daging Beku", "Siapa bilang bikin baso sapi harus selalu menggunakan daging segar? pake daging beku pun ternyata bisa bun. Hasilnya tetap bagus, lembut dan kenyal. Jadi, kalau bunda pingin bikin bakso menggunakan stok daging yang ada di kulkas, bisa mencoba resep yang satu ini. Hanya dibutuhkan waktu 60 menit saja untuk membuat bakso sapi yang kenyal, lembut walopun memakai Daging frozen.", "https://3.bp.blogspot.com/-W8T4OCaaSCQ/WoOIktXCDCI/AAAAAAAAFvA/mH3AMBdU_1kYsdPCuhMyWtUnetKTMSzwQCLcBGAs/s1600/photo%2B%25284%2529.jpg", "https://www.modern.id/2018/02/bakso-sapi-kenyal-lembut-walau-memakai.html"))
        artikelList.add(Artikel("Membuat Bakso Dari Daging Beku", "Siapa bilang bikin baso sapi harus selalu menggunakan daging segar? pake daging beku pun ternyata bisa bun. Hasilnya tetap bagus, lembut dan kenyal. Jadi, kalau bunda pingin bikin bakso menggunakan stok daging yang ada di kulkas, bisa mencoba resep yang satu ini. Hanya dibutuhkan waktu 60 menit saja untuk membuat bakso sapi yang kenyal, lembut walopun memakai Daging frozen.", "https://3.bp.blogspot.com/-W8T4OCaaSCQ/WoOIktXCDCI/AAAAAAAAFvA/mH3AMBdU_1kYsdPCuhMyWtUnetKTMSzwQCLcBGAs/s1600/photo%2B%25284%2529.jpg", "https://www.modern.id/2018/02/bakso-sapi-kenyal-lembut-walau-memakai.html"))
        artikelList.add(Artikel("Membuat Bakso Dari Daging Beku", "Siapa bilang bikin baso sapi harus selalu menggunakan daging segar? pake daging beku pun ternyata bisa bun. Hasilnya tetap bagus, lembut dan kenyal. Jadi, kalau bunda pingin bikin bakso menggunakan stok daging yang ada di kulkas, bisa mencoba resep yang satu ini. Hanya dibutuhkan waktu 60 menit saja untuk membuat bakso sapi yang kenyal, lembut walopun memakai Daging frozen.", "https://3.bp.blogspot.com/-W8T4OCaaSCQ/WoOIktXCDCI/AAAAAAAAFvA/mH3AMBdU_1kYsdPCuhMyWtUnetKTMSzwQCLcBGAs/s1600/photo%2B%25284%2529.jpg", "https://www.modern.id/2018/02/bakso-sapi-kenyal-lembut-walau-memakai.html"))
        return artikelList
    }

    inner class BeritaAdapter(private val artikelList: ArrayList<Artikel>) :
        RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {

        inner class BeritaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val judulTextView: TextView = itemView.findViewById(R.id.tv_judul)
            val deskripsiTextView: TextView = itemView.findViewById(R.id.tv_description)
            val gambarImageView: ImageView = itemView.findViewById(R.id.img_item_photo)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_artikel, parent, false)
            return BeritaViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
            val berita = artikelList[position]
            holder.judulTextView.text = berita.judul
            holder.deskripsiTextView.text = berita.deskripsi

            Glide.with(holder.itemView)
                .load(berita.gambarUrl)
                .into(holder.gambarImageView)

            holder.itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(berita.url))
                startActivity(intent)
            }
        }


        override fun getItemCount(): Int {
            return artikelList.size
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_language_setting -> {
                val languageIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(languageIntent)
                return true
            }
            R.id.btn_logout -> {
                val sharedPref = requireContext().getSharedPreferences(getString(R.string.pref_name), Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString(getString(R.string.user_token), "")
                editor.remove(getString(R.string.upload_token))
                editor.apply()

                val logoutIntent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(logoutIntent)
                requireActivity().finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        var USER_TOKEN: String? = "USER_TOKEN"
    }
}
