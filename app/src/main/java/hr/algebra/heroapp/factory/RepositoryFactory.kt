package hr.algebra.heroapp.factory

import android.content.Context
import hr.algebra.heroapp.dao.HeroSqlHelper

fun getHeroRepository(context: Context?) = HeroSqlHelper(context)