package net.haipadev.washedminerals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.haipadev.washedminerals.WashedMineralsMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.Calendar;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class ConfigWriteProcedure {
	public static void execute(LevelAccessor world) {
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subJson = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subJsonCategory = new com.google.gson.JsonObject();
		double i = 0;
		double c = 0;
		String categoryToCheck = "";
		String configName = "";
		String configDir = "";
		String configBackupSubdir = "";
		String configBackupFullpath = "";
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
			i = 1;
			for (int index0 = 0; index0 < 4; index0++) {
				if (i == 1) {
					subJson.addProperty("item", "minecraft:gravel");
					subJson.addProperty("amntPerProcess", Math.round(8));
					subJson.addProperty("processingTimeTicks", Math.round(180));
					subJson.addProperty("chanceForSuccess", Math.round(70));
					subJson.addProperty("checkChancePerItem", true);
					subJson.addProperty("drop", "minecraft:iron_nugget");
					subJson.addProperty("dropratePerOne", Math.round(1));
				} else if (i == 2) {
					subJson.addProperty("item", "minecraft:red_sand");
					subJson.addProperty("amntPerProcess", Math.round(4));
					subJson.addProperty("processingTimeTicks", Math.round(180));
					subJson.addProperty("chanceForSuccess", Math.round(50));
					subJson.addProperty("checkChancePerItem", true);
					subJson.addProperty("drop", "minecraft:gold_nugget");
					subJson.addProperty("dropratePerOne", Math.round(1));
				} else if (i == 3) {
					subJson.addProperty("item", "washed_minerals:dead_redstone_block");
					subJson.addProperty("amntPerProcess", Math.round(1));
					subJson.addProperty("processingTimeTicks", Math.round(180));
					subJson.addProperty("chanceForSuccess", Math.round(1));
					subJson.addProperty("checkChancePerItem", true);
					subJson.addProperty("drop", "minecraft:echo_shard");
					subJson.addProperty("dropratePerOne", Math.round(1));
				} else if (i == 4) {
					subJson.addProperty("item", "minecraft:sand");
					subJson.addProperty("amntPerProcess", Math.round(8));
					subJson.addProperty("processingTimeTicks", Math.round(180));
					subJson.addProperty("chanceForSuccess", Math.round(70));
					subJson.addProperty("checkChancePerItem", true);
					subJson.addProperty("drop", "minecraft:clay_ball");
					subJson.addProperty("dropratePerOne", Math.round(1));
				}
				subJsonCategory.add(("item" + Math.round(i)), subJson);
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
			i = 1;
			for (int index1 = 0; index1 < 3; index1++) {
				if (i == 1) {
					subJson.addProperty("item", "minecraft:dirt");
					subJson.addProperty("amntPerProcess", Math.round(16));
					subJson.addProperty("processingTimeTicks", Math.round(180));
					subJson.addProperty("chanceForSuccess", Math.round(80));
					subJson.addProperty("checkChancePerItem", true);
					subJson.addProperty("drop", "minecraft:soul_soil");
					subJson.addProperty("dropratePerOne", Math.round(1));
				} else if (i == 2) {
					subJson.addProperty("item", "minecraft:sand");
					subJson.addProperty("amntPerProcess", Math.round(16));
					subJson.addProperty("processingTimeTicks", Math.round(180));
					subJson.addProperty("chanceForSuccess", Math.round(80));
					subJson.addProperty("checkChancePerItem", true);
					subJson.addProperty("drop", "minecraft:soul_sand");
					subJson.addProperty("dropratePerOne", Math.round(1));
				} else if (i == 3) {
					subJson.addProperty("item", "minecraft:cobblestone");
					subJson.addProperty("amntPerProcess", Math.round(16));
					subJson.addProperty("processingTimeTicks", Math.round(180));
					subJson.addProperty("chanceForSuccess", Math.round(80));
					subJson.addProperty("checkChancePerItem", true);
					subJson.addProperty("drop", "minecraft:netherrack");
					subJson.addProperty("dropratePerOne", Math.round(1));
				}
				subJsonCategory.add(("item" + Math.round(i)), subJson);
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
			i = 1;
			for (int index2 = 0; index2 < 1; index2++) {
				if (i == 1) {
					subJson.addProperty("item", "minecraft:cobblestone");
					subJson.addProperty("amntPerProcess", Math.round(16));
					subJson.addProperty("processingTimeTicks", Math.round(180));
					subJson.addProperty("chanceForSuccess", Math.round(80));
					subJson.addProperty("checkChancePerItem", true);
					subJson.addProperty("drop", "minecraft:stone");
					subJson.addProperty("dropratePerOne", Math.round(1));
				}
				subJsonCategory.add(("item" + Math.round(i)), subJson);
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
			i = 1;
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
					i = 1;
					for (int index3 = 0; index3 < 3; index3++) {
						if (c == 2) {
							categoryToCheck = "haunting";
						} else if (c == 3) {
							categoryToCheck = "blasting";
						}
						if (json.has(categoryToCheck)) {
							subJsonCategory = json.get(categoryToCheck).getAsJsonObject();
							for (int index4 = 0; index4 < (int) subJsonCategory.size(); index4++) {
								if (subJsonCategory.has(("item" + Math.round(i)))) {
									subJson = subJsonCategory.get(("item" + Math.round(i))).getAsJsonObject();
									if (!subJson.has("item") || !subJson.has("amntPerProcess") || !subJson.has("processingTimeTicks") || !subJson.has("chanceForSuccess") || !subJson.has("checkChancePerItem") || !subJson.has("drop")
											|| !subJson.has("dropratePerOne")) {
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
															world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
																	"one of properties \"item\" / \"amntPerProcess\" / \"processingTimeTicks\" / \"chanceForSuccess\" / \"checkChancePerItem\" / \"drop\" / \"dropratePerOne\" not found in one of the items"),
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
														world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("incorrectly numbered items in one of the categories"), false);
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
								i = i + 1;
							}
							i = 1;
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
