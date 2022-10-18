package com.tsci.fake_ecommerce

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.tsci.fake_ecommerce.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mNavController: NavController
    lateinit var mNavHostFragment: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         mNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
        mNavController = mNavHostFragment.navController
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_graph_home, R.id.nav_graph_cart, R.id.nav_graph_profile)
        )
        mNavController.addOnDestinationChangedListener { controller, destination, arguments ->
            binding.bottomNavbar.isVisible = appBarConfiguration.topLevelDestinations.contains(destination.parent?.id)
        }
        binding.bottomNavbar.setupWithNavController(mNavController)

    }
    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp(appBarConfiguration)
    }

    fun setNavigationGraph(@NavigationRes graph: Int){
        mNavController.setGraph(graph)
    }
}