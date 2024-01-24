package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.haipadev.washedminerals.WashedMineralsMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.Set;
import java.util.Map;
import java.util.Calendar;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class ConfigWriteProcedure {
	public static void execute(LevelAccessor world) {
		File file = new File("");
		String categoryToCheck = "";
		String configName = "";
		String configDir = "";
		String configBackupSubdir = "";
		String configBackupFullpath = "";
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subJson = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subJsonCategory = new com.google.gson.JsonObject();
		com.google.gson.JsonObject dropsJson = new com.google.gson.JsonObject();
		com.google.gson.JsonObject dropsSubJson = new com.google.gson.JsonObject();
		double i = 0;
		double c = 0;
		double d = 0;
		configName = "config.json";
		configDir = Minecraft.getInstance().gameDirectory + "/config/washed_minerals/";
		configBackupSubdir = "backup/";
		configBackupFullpath = configDir + "" + configBackupSubdir + configName.replace(".json", "_") + new java.text.SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(Calendar.getInstance().getTime()) + ".json";
		file = (File) new File(configDir, File.separator + configName);
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			json.addProperty("redstoneBlockDeathTicks", 6000);
			json.addProperty("redstoneBlockDeathChance", 80);
			i = 0;
			for (int index0 = 0; index0 < 4; index0++) {
				if (i == 0) {
					subJson.addProperty("amntPerProcess", Math.round(8));
					subJson.addProperty("processingTimeTicks", Math.round(180));
					for (int index1 = 0; index1 < 1; index1++) {
						dropsSubJson.addProperty("chanceForSuccess", Math.round(70));
						dropsSubJson.addProperty("checkChancePerSingleItem", true);
						dropsSubJson.addProperty("dropratePerOne", Math.round(1));
						dropsJson.add("minecraft:iron_nugget", dropsSubJson);
						dropsSubJson = new Object() {
							public JsonObject parse(String rawJson) {
								try {
									return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
								} catch (Exception e) {
									WashedMineralsMod.LOGGER.error(e);
									return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
								}
							}
						}.parse("{}");
					}
					subJson.add("drops", dropsJson);
					dropsJson = new Object() {
						public JsonObject parse(String rawJson) {
							try {
								return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
							} catch (Exception e) {
								WashedMineralsMod.LOGGER.error(e);
								return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
							}
						}
					}.parse("{}");
					subJsonCategory.add("minecraft:gravel", subJson);
				} else if (i == 1) {
					subJson.addProperty("amntPerProcess", Math.round(1));
					subJson.addProperty("processingTimeTicks", Math.round(180));
					for (int index2 = 0; index2 < 1; index2++) {
						dropsSubJson.addProperty("chanceForSuccess", Math.round(50));
						dropsSubJson.addProperty("checkChancePerSingleItem", true);
						dropsSubJson.addProperty("dropratePerOne", Math.round(1));
						dropsJson.add("minecraft:gold_nugget", dropsSubJson);
						dropsSubJson = new Object() {
							public JsonObject parse(String rawJson) {
								try {
									return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
								} catch (Exception e) {
									WashedMineralsMod.LOGGER.error(e);
									return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
								}
							}
						}.parse("{}");
					}
					subJson.add("drops", dropsJson);
					dropsJson = new Object() {
						public JsonObject parse(String rawJson) {
							try {
								return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
							} catch (Exception e) {
								WashedMineralsMod.LOGGER.error(e);
								return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
							}
						}
					}.parse("{}");
					subJsonCategory.add("minecraft:red_sand", subJson);
				} else if (i == 2) {
					subJson.addProperty("amntPerProcess", Math.round(1));
					subJson.addProperty("processingTimeTicks", Math.round(300));
					for (int index3 = 0; index3 < 1; index3++) {
						dropsSubJson.addProperty("chanceForSuccess", Math.round(1));
						dropsSubJson.addProperty("checkChancePerSingleItem", true);
						dropsSubJson.addProperty("dropratePerOne", Math.round(1));
						dropsJson.add("minecraft:echo_shard", dropsSubJson);
						dropsSubJson = new Object() {
							public JsonObject parse(String rawJson) {
								try {
									return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
								} catch (Exception e) {
									WashedMineralsMod.LOGGER.error(e);
									return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
								}
							}
						}.parse("{}");
					}
					subJson.add("drops", dropsJson);
					dropsJson = new Object() {
						public JsonObject parse(String rawJson) {
							try {
								return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
							} catch (Exception e) {
								WashedMineralsMod.LOGGER.error(e);
								return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
							}
						}
					}.parse("{}");
					subJsonCategory.add("washed_minerals:dead_redstone_block", subJson);
				} else if (i == 3) {
					subJson.addProperty("amntPerProcess", Math.round(1));
					subJson.addProperty("processingTimeTicks", Math.round(300));
					for (int index4 = 0; index4 < 1; index4++) {
						dropsSubJson.addProperty("chanceForSuccess", Math.round(80));
						dropsSubJson.addProperty("checkChancePerSingleItem", true);
						dropsSubJson.addProperty("dropratePerOne", Math.round(2));
						dropsJson.add("minecraft:clay_ball", dropsSubJson);
						dropsSubJson = new Object() {
							public JsonObject parse(String rawJson) {
								try {
									return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
								} catch (Exception e) {
									WashedMineralsMod.LOGGER.error(e);
									return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
								}
							}
						}.parse("{}");
					}
					subJson.add("drops", dropsJson);
					dropsJson = new Object() {
						public JsonObject parse(String rawJson) {
							try {
								return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
							} catch (Exception e) {
								WashedMineralsMod.LOGGER.error(e);
								return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
							}
						}
					}.parse("{}");
					subJsonCategory.add("minecraft:sand", subJson);
				}
				subJson = new Object() {
					public JsonObject parse(String rawJson) {
						try {
							return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
						} catch (Exception e) {
							WashedMineralsMod.LOGGER.error(e);
							return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
						}
					}
				}.parse("{}");
				i = i + 1;
			}
			json.add("washing", subJsonCategory);
			subJsonCategory = new Object() {
				public JsonObject parse(String rawJson) {
					try {
						return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
					} catch (Exception e) {
						WashedMineralsMod.LOGGER.error(e);
						return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
					}
				}
			}.parse("{}");
			i = 0;
			for (int index5 = 0; index5 < 4; index5++) {
				if (i == 0) {
					subJson.addProperty("amntPerProcess", Math.round(16));
					subJson.addProperty("processingTimeTicks", Math.round(200));
					for (int index6 = 0; index6 < 1; index6++) {
						dropsSubJson.addProperty("chanceForSuccess", Math.round(80));
						dropsSubJson.addProperty("checkChancePerSingleItem", true);
						dropsSubJson.addProperty("dropratePerOne", Math.round(1));
						dropsJson.add("minecraft:soul_soil", dropsSubJson);
						dropsSubJson = new Object() {
							public JsonObject parse(String rawJson) {
								try {
									return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
								} catch (Exception e) {
									WashedMineralsMod.LOGGER.error(e);
									return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
								}
							}
						}.parse("{}");
					}
					subJson.add("drops", dropsJson);
					dropsJson = new Object() {
						public JsonObject parse(String rawJson) {
							try {
								return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
							} catch (Exception e) {
								WashedMineralsMod.LOGGER.error(e);
								return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
							}
						}
					}.parse("{}");
					subJsonCategory.add("minecraft:dirt", subJson);
				} else if (i == 1) {
					subJson.addProperty("amntPerProcess", Math.round(16));
					subJson.addProperty("processingTimeTicks", Math.round(200));
					for (int index7 = 0; index7 < 1; index7++) {
						dropsSubJson.addProperty("chanceForSuccess", Math.round(80));
						dropsSubJson.addProperty("checkChancePerSingleItem", true);
						dropsSubJson.addProperty("dropratePerOne", Math.round(1));
						dropsJson.add("minecraft:soul_sand", dropsSubJson);
						dropsSubJson = new Object() {
							public JsonObject parse(String rawJson) {
								try {
									return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
								} catch (Exception e) {
									WashedMineralsMod.LOGGER.error(e);
									return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
								}
							}
						}.parse("{}");
					}
					subJson.add("drops", dropsJson);
					dropsJson = new Object() {
						public JsonObject parse(String rawJson) {
							try {
								return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
							} catch (Exception e) {
								WashedMineralsMod.LOGGER.error(e);
								return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
							}
						}
					}.parse("{}");
					subJsonCategory.add("minecraft:sand", subJson);
				} else if (i == 2) {
					subJson.addProperty("amntPerProcess", Math.round(16));
					subJson.addProperty("processingTimeTicks", Math.round(200));
					for (int index8 = 0; index8 < 1; index8++) {
						dropsSubJson.addProperty("chanceForSuccess", Math.round(80));
						dropsSubJson.addProperty("checkChancePerSingleItem", true);
						dropsSubJson.addProperty("dropratePerOne", Math.round(1));
						dropsJson.add("minecraft:netherrack", dropsSubJson);
						dropsSubJson = new Object() {
							public JsonObject parse(String rawJson) {
								try {
									return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
								} catch (Exception e) {
									WashedMineralsMod.LOGGER.error(e);
									return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
								}
							}
						}.parse("{}");
					}
					subJson.add("drops", dropsJson);
					dropsJson = new Object() {
						public JsonObject parse(String rawJson) {
							try {
								return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
							} catch (Exception e) {
								WashedMineralsMod.LOGGER.error(e);
								return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
							}
						}
					}.parse("{}");
					subJsonCategory.add("minecraft:cobblestone", subJson);
				} else if (i == 3) {
					subJson.addProperty("amntPerProcess", Math.round(8));
					subJson.addProperty("processingTimeTicks", Math.round(220));
					for (int index9 = 0; index9 < 1; index9++) {
						dropsSubJson.addProperty("chanceForSuccess", Math.round(50));
						dropsSubJson.addProperty("checkChancePerSingleItem", true);
						dropsSubJson.addProperty("dropratePerOne", Math.round(1));
						dropsJson.add("minecraft:prismarine_shard", dropsSubJson);
						dropsSubJson = new Object() {
							public JsonObject parse(String rawJson) {
								try {
									return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
								} catch (Exception e) {
									WashedMineralsMod.LOGGER.error(e);
									return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
								}
							}
						}.parse("{}");
					}
					subJson.add("drops", dropsJson);
					dropsJson = new Object() {
						public JsonObject parse(String rawJson) {
							try {
								return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
							} catch (Exception e) {
								WashedMineralsMod.LOGGER.error(e);
								return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
							}
						}
					}.parse("{}");
					subJsonCategory.add("minecraft:lapis_lazuli", subJson);
				}
				subJson = new Object() {
					public JsonObject parse(String rawJson) {
						try {
							return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
						} catch (Exception e) {
							WashedMineralsMod.LOGGER.error(e);
							return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
						}
					}
				}.parse("{}");
				i = i + 1;
			}
			json.add("haunting", subJsonCategory);
			subJsonCategory = new Object() {
				public JsonObject parse(String rawJson) {
					try {
						return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
					} catch (Exception e) {
						WashedMineralsMod.LOGGER.error(e);
						return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
					}
				}
			}.parse("{}");
			i = 0;
			for (int index10 = 0; index10 < 2; index10++) {
				if (i == 0) {
					subJson.addProperty("amntPerProcess", Math.round(32));
					subJson.addProperty("processingTimeTicks", Math.round(300));
					for (int index11 = 0; index11 < 1; index11++) {
						dropsSubJson.addProperty("chanceForSuccess", Math.round(85));
						dropsSubJson.addProperty("checkChancePerSingleItem", true);
						dropsSubJson.addProperty("dropratePerOne", Math.round(1));
						dropsJson.add("minecraft:stone", dropsSubJson);
						dropsSubJson = new Object() {
							public JsonObject parse(String rawJson) {
								try {
									return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
								} catch (Exception e) {
									WashedMineralsMod.LOGGER.error(e);
									return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
								}
							}
						}.parse("{}");
					}
					subJson.add("drops", dropsJson);
					dropsJson = new Object() {
						public JsonObject parse(String rawJson) {
							try {
								return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
							} catch (Exception e) {
								WashedMineralsMod.LOGGER.error(e);
								return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
							}
						}
					}.parse("{}");
					subJsonCategory.add("minecraft:cobblestone", subJson);
				} else if (i == 1) {
					subJson.addProperty("amntPerProcess", Math.round(32));
					subJson.addProperty("processingTimeTicks", Math.round(300));
					for (int index12 = 0; index12 < 1; index12++) {
						dropsSubJson.addProperty("chanceForSuccess", Math.round(70));
						dropsSubJson.addProperty("checkChancePerSingleItem", true);
						dropsSubJson.addProperty("dropratePerOne", Math.round(1));
						dropsJson.add("minecraft:glass", dropsSubJson);
						dropsSubJson = new Object() {
							public JsonObject parse(String rawJson) {
								try {
									return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
								} catch (Exception e) {
									WashedMineralsMod.LOGGER.error(e);
									return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
								}
							}
						}.parse("{}");
					}
					subJson.add("drops", dropsJson);
					dropsJson = new Object() {
						public JsonObject parse(String rawJson) {
							try {
								return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
							} catch (Exception e) {
								WashedMineralsMod.LOGGER.error(e);
								return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
							}
						}
					}.parse("{}");
					subJsonCategory.add("minecraft:sand", subJson);
				}
				subJson = new Object() {
					public JsonObject parse(String rawJson) {
						try {
							return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
						} catch (Exception e) {
							WashedMineralsMod.LOGGER.error(e);
							return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
						}
					}
				}.parse("{}");
				i = i + 1;
			}
			json.add("blasting", subJsonCategory);
			subJsonCategory = new Object() {
				public JsonObject parse(String rawJson) {
					try {
						return new Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
					} catch (Exception e) {
						WashedMineralsMod.LOGGER.error(e);
						return new Gson().fromJson("{}", com.google.gson.JsonObject.class);
					}
				}
			}.parse("{}");
			i = 0;
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(json));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					json = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					categoryToCheck = "washing";
					c = 1;
					i = 0;
					for (int index13 = 0; index13 < 3; index13++) {
						if (c == 2) {
							categoryToCheck = "haunting";
						} else if (c == 3) {
							categoryToCheck = "blasting";
						}
						if (json.has(categoryToCheck)) {
							subJsonCategory = json.get(categoryToCheck).getAsJsonObject();
							for (int index14 = 0; index14 < (int) subJsonCategory.size(); index14++) {
								if (subJsonCategory.has((new Object() {
									public String getKeyByIndex(JsonObject jsonObject, double _index) {
										int index = (int) _index;
										Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
										if (index >= 0 && index < entries.size()) {
											int currentIndex = 0;
											for (Map.Entry<String, JsonElement> entry : entries) {
												if (currentIndex == index) {
													String targetKey = entry.getKey();
													return targetKey;
												}
												currentIndex++;
											}
										} else if (index < 0 && Math.abs(index) <= entries.size()) {
											int currentIndex = entries.size() - 1;
											for (Map.Entry<String, JsonElement> entry : entries) {
												if (currentIndex == Math.abs(index) - 1) {
													String targetKey = entry.getKey();
													return targetKey;
												}
												currentIndex--;
											}
										}
										if (index >= 0) {
											WashedMineralsMod.LOGGER.error(index + " is outside the bounds of the json!");
										} else {
											WashedMineralsMod.LOGGER.error(index + " [" + (Math.abs(index) - 1) + "]" + " is outside the bounds of the json!");
										}
										return "";
									}
								}.getKeyByIndex(subJsonCategory, i)))) {
									subJson = subJsonCategory.get((new Object() {
										public String getKeyByIndex(JsonObject jsonObject, double _index) {
											int index = (int) _index;
											Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
											if (index >= 0 && index < entries.size()) {
												int currentIndex = 0;
												for (Map.Entry<String, JsonElement> entry : entries) {
													if (currentIndex == index) {
														String targetKey = entry.getKey();
														return targetKey;
													}
													currentIndex++;
												}
											} else if (index < 0 && Math.abs(index) <= entries.size()) {
												int currentIndex = entries.size() - 1;
												for (Map.Entry<String, JsonElement> entry : entries) {
													if (currentIndex == Math.abs(index) - 1) {
														String targetKey = entry.getKey();
														return targetKey;
													}
													currentIndex--;
												}
											}
											if (index >= 0) {
												WashedMineralsMod.LOGGER.error(index + " is outside the bounds of the json!");
											} else {
												WashedMineralsMod.LOGGER.error(index + " [" + (Math.abs(index) - 1) + "]" + " is outside the bounds of the json!");
											}
											return "";
										}
									}.getKeyByIndex(subJsonCategory, i))).getAsJsonObject();
									if (!subJson.has("amntPerProcess") || !subJson.has("processingTimeTicks") || !subJson.has("drops")) {
										new Object() {
											private int ticks = 0;

											public void startDelay(LevelAccessor world) {
												ServerTickEvents.END_SERVER_TICK.register((server) -> {
													this.ticks++;
													if (this.ticks == 20) {
														if (!world.isClientSide() && world.getServer() != null)
															world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7cIncorrect config for WashedMinerals, regenerating new one and backuping old"), false);
														if (!world.isClientSide() && world.getServer() != null)
															world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(""), false);
														if (!world.isClientSide() && world.getServer() != null)
															world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("one of properties \"amntPerProcess\" / \"processingTimeTicks\" / \"drops\" not found in one of the items"),
																	false);
														return;
													}
												});
											}
										}.startDelay(world);
										try {
											org.apache.commons.io.FileUtils.moveFile(file, new File(configBackupFullpath));
										} catch (IOException e) {
											WashedMineralsMod.LOGGER.error(e);
										}
										ConfigWriteProcedure.execute(world);
										break;
									} else {
										d = 0;
										dropsJson = subJson.get("drops").getAsJsonObject();
										for (int index15 = 0; index15 < (int) dropsJson.size(); index15++) {
											dropsSubJson = dropsJson.get((new Object() {
												public String getKeyByIndex(JsonObject jsonObject, double _index) {
													int index = (int) _index;
													Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
													if (index >= 0 && index < entries.size()) {
														int currentIndex = 0;
														for (Map.Entry<String, JsonElement> entry : entries) {
															if (currentIndex == index) {
																String targetKey = entry.getKey();
																return targetKey;
															}
															currentIndex++;
														}
													} else if (index < 0 && Math.abs(index) <= entries.size()) {
														int currentIndex = entries.size() - 1;
														for (Map.Entry<String, JsonElement> entry : entries) {
															if (currentIndex == Math.abs(index) - 1) {
																String targetKey = entry.getKey();
																return targetKey;
															}
															currentIndex--;
														}
													}
													if (index >= 0) {
														WashedMineralsMod.LOGGER.error(index + " is outside the bounds of the json!");
													} else {
														WashedMineralsMod.LOGGER.error(index + " [" + (Math.abs(index) - 1) + "]" + " is outside the bounds of the json!");
													}
													return "";
												}
											}.getKeyByIndex(dropsJson, d))).getAsJsonObject();
											if (!dropsSubJson.has("chanceForSuccess") || !dropsSubJson.has("checkChancePerSingleItem") || !dropsSubJson.has("dropratePerOne")) {
												new Object() {
													private int ticks = 0;

													public void startDelay(LevelAccessor world) {
														ServerTickEvents.END_SERVER_TICK.register((server) -> {
															this.ticks++;
															if (this.ticks == 20) {
																if (!world.isClientSide() && world.getServer() != null)
																	world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7cIncorrect config for WashedMinerals, regenerating new one and backuping old"), false);
																if (!world.isClientSide() && world.getServer() != null)
																	world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(""), false);
																if (!world.isClientSide() && world.getServer() != null)
																	world.getServer().getPlayerList()
																			.broadcastSystemMessage(Component.literal("one of properties \"chanceForSuccess\" / \"checkChancePerSingleItem\" / \"dropratePerOne\" not found in one of the drops"), false);
																return;
															}
														});
													}
												}.startDelay(world);
												try {
													org.apache.commons.io.FileUtils.moveFile(file, new File(configBackupFullpath));
												} catch (IOException e) {
													WashedMineralsMod.LOGGER.error(e);
												}
												ConfigWriteProcedure.execute(world);
												break;
											}
											d = d + 1;
										}
									}
								} else {
									new Object() {
										private int ticks = 0;

										public void startDelay(LevelAccessor world) {
											ServerTickEvents.END_SERVER_TICK.register((server) -> {
												this.ticks++;
												if (this.ticks == 20) {
													if (!world.isClientSide() && world.getServer() != null)
														world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7cIncorrect config for WashedMinerals, regenerating new one and backuping old"), false);
													if (!world.isClientSide() && world.getServer() != null)
														world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(""), false);
													if (!world.isClientSide() && world.getServer() != null)
														world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("not sure? something went wrong regarding length of the loop checking for item ids"), false);
													return;
												}
											});
										}
									}.startDelay(world);
									break;
								}
								i = i + 1;
							}
							i = 0;
						} else {
							new Object() {
								private int ticks = 0;

								public void startDelay(LevelAccessor world) {
									ServerTickEvents.END_SERVER_TICK.register((server) -> {
										this.ticks++;
										if (this.ticks == 20) {
											if (!world.isClientSide() && world.getServer() != null)
												world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7cIncorrect config for WashedMinerals, regenerating new one and backuping old"), false);
											if (!world.isClientSide() && world.getServer() != null)
												world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(""), false);
											if (!world.isClientSide() && world.getServer() != null)
												world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("one of categories \"washing\" / \"haunting\" / \"blasting\" not found"), false);
											return;
										}
									});
								}
							}.startDelay(world);
							try {
								org.apache.commons.io.FileUtils.moveFile(file, new File(configBackupFullpath));
							} catch (IOException e) {
								WashedMineralsMod.LOGGER.error(e);
							}
							ConfigWriteProcedure.execute(world);
							break;
						}
						c = c + 1;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
